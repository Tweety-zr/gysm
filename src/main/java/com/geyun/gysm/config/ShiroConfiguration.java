package com.geyun.gysm.config;

import com.geyun.gysm.realm.GyRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 崔世良
 * @date 2020/1/20 16:32
 * @editer 崔世良
 * @editdate 2020/1/20 16:32
 * @description
 */
@Configuration
public class ShiroConfiguration {
    //1.创建realm
    @Bean
    public GyRealm getRealm() {
        return new GyRealm();
    }

    //2.创建安全管理器
    @Bean
    public SecurityManager getSecurityManager(GyRealm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        //将自定义的会话管理器注册到安全管理器中
//        securityManager.setSessionManager(sessionManager());
        //将自定义的redis缓存管理器注册到安全管理器中
//        securityManager.setCacheManager(cacheManager());
        return securityManager;
    }

    //3.配置shiro的过滤器工厂

    /**
     * 再web程序中，shiro进行权限控制全部是通过一组过滤器集合进行控制
     *
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        //1.创建过滤器工厂
        ShiroFilterFactoryBean filterFactory = new ShiroFilterFactoryBean();
        //2.设置安全管理器
        filterFactory.setSecurityManager(securityManager);
        //3.通用配置（跳转登录页面，为授权跳转的页面）
        filterFactory.setLoginUrl("/view/log112in.html");//跳转url地址
        filterFactory.setUnauthorizedUrl("/autherror?code=2");//未授权的url
        //4.设置过滤器集合
        /**
         * 设置所有的过滤器：有顺序map
         *     key = 拦截的url地址
         *     value = 过滤器类型
         *
         */
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/base/resetPwd","anon");//当前请求地址可以匿名访问
        //具有某中权限才能访问
        //使用过滤器的形式配置请求地址的依赖权限
        //filterMap.put("/user/home","perms[user-home]"); //不具备指定的权限，跳转到setUnauthorizedUrl地址

        //使用过滤器的形式配置请求地址的依赖角色
        //filterMap.put("/user/home","roles[系统管理员]");

        filterMap.put("/base/**","authc");//当前请求地址必须认证之后可以访问

        filterFactory.setFilterChainDefinitionMap(filterMap);

        return filterFactory;
    }


    //开启对shior注解的支持
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
