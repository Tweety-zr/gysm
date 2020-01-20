package com.geyun.gysm.realm;

import com.geyun.gysm.base.model.BaseUser;
import com.geyun.gysm.base.service.BaseService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 崔世良
 * @date 2020/1/19 17:57
 * @editer 崔世良
 * @editdate 2020/1/19 17:57
 * @description Realm域
 */
public class GyRealm extends AuthorizingRealm {

    @Autowired
    private BaseService baseService;

    @Override
    public void setName(String name) {
        super.setName("gyRealm");
    }

    /**
     * 授权方法
     *  授权方法
     *   操作的时候，判断用户是否具有响应的权限
     *      先认证 -- 安全数据
     *      再授权 -- 根据安全数据获取用户具有的所有操作权限
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //1.获取已认证的用户数据  得到唯一的安全数据
        BaseUser baseUser = (BaseUser) principals.getPrimaryPrincipal();
        //2.根据用户数据获取用户的权限信息（所有角色，所有权限）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> perms = new HashSet<>();
        baseUser.getBaseRole().getBasePermissionList().forEach(basePermission -> {
            perms.add(basePermission.getStrPermName());
        });
        //添加角色
        info.addRole(baseUser.getBaseRole().getStrRoleName());
        //所有权限
        info.addStringPermissions(perms);
        return info;
    }

    /**
     * 认证方法
     * @param token 用户名密码
     * @return
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //1.获取登录的用户名密码（token）
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String account = upToken.getUsername();
        String strPassWord = String.valueOf(upToken.getPassword());
        //2.根据用户名查询数据库
        BaseUser baseUser = baseService.cheakAccount(account);
        //3.判断用户是否存在或者密码是否一致
        if(baseUser != null && baseUser.equals(strPassWord)){
            //4.如果一致返回安全数据
            //构造方法：安全数据，密码，realm域名
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(baseUser,baseUser.getStrPasswd(),this.getName());
            return info;
        }
        //5.不一致，返回null（抛出异常）
        return null;
    }

}
