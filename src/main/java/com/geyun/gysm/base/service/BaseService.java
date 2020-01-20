package com.geyun.gysm.base.service;

import com.geyun.gysm.base.model.BaseUser;
import com.geyun.gysm.utils.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author 崔世良
 * @date 2020/1/20 13:45
 * @editer 崔世良
 * @editdate 2020/1/20 13:45
 * @description
 */
public interface BaseService {

    /**
     * 检查账户是否存在
     * @param  account
     * @return
     */
    BaseUser cheakAccount(String account);

    /**
     * 重置密码
     * @param param,request
     * @return
     */
    Result resetPwd(HashMap param, HttpServletRequest request);

    /**
     * 重置锁屏密码
     * @param param,request
     * @return
     */
    Result resetScreenPwd(HashMap param, HttpServletRequest request);

}
