package com.geyun.gysm.base.model;

import lombok.Data;

/**
 * @author 崔世良
 * @date 2020/1/20 11:51
 * @editer 崔世良
 * @editdate 2020/1/20 11:51
 * @description 用户实体
 */
@Data
public class BaseUser {

    /**
     * 自增主键
     **/
    private int iNo;
    /**
     * 唯一guid
     **/
    private String strGuid;
    /**
     * 人员名称
     **/
    private String strName;
    /**
     * 手机号
     **/
    private String strMobile;
    /**
     * 登录名
     **/
    private String strAccount;
    /**
     * 虚拟账号密码 md5
     **/
    private String strPasswd;
    /**
     * 性别 1男; 0 女;
     **/
    private String strSex;
    /**
     * 锁屏密码
     **/
    private String strScreenPwd;
    /**
     * 用户角色
     **/
    private BaseRole baseRole;
}
