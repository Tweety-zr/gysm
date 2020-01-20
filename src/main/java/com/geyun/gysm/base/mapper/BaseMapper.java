package com.geyun.gysm.base.mapper;

import com.geyun.gysm.base.model.BasePermission;
import com.geyun.gysm.base.model.BaseRole;
import com.geyun.gysm.base.model.BaseUser;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author 崔世良
 * @date 2020/1/20 13:59
 * @editer 崔世良
 * @editdate 2020/1/20 13:59
 * @description
 */
@Repository
public interface BaseMapper {

    /**
     * 检查账户是否存在
     * @param account
     * @return
     */
    BaseUser cheakAccount(String account);


    /**
     * 根据用户guid查角色
     * @param param
     * @return
     */
    BaseRole selRoleByUId(HashMap param);

    /**
     * 根据用户角色id查权限
     * @param param
     * @return
     */
    List<BasePermission> selPermByRId(HashMap param);

    /**
     * 重置密码
     * @param param
     * @return
     */
    int resetPwd(HashMap param);

    /**
     * 重置锁屏密码
     * @param param
     * @return
     */
    int resetScreenPwd(HashMap param);
}
