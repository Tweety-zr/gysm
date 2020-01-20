package com.geyun.gysm.base.service.impl;

import com.geyun.gysm.base.mapper.BaseMapper;
import com.geyun.gysm.base.model.BaseUser;
import com.geyun.gysm.base.service.BaseService;
import com.geyun.gysm.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author 崔世良
 * @date 2020/1/20 13:54
 * @editer 崔世良
 * @editdate 2020/1/20 13:54
 * @description
 */
@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    private BaseMapper baseMapper;

    @Override
    public BaseUser cheakAccount(String account) {
        BaseUser baseUser = baseMapper.cheakAccount(account);
        if(baseUser != null){
            HashMap<String,String> param = new HashMap<>();
            param.put("strGuid",baseUser.getStrGuid());
            baseUser.setBaseRole(baseMapper.selRoleByUId(param));
            param.put("strGuid",baseUser.getBaseRole().getStrGuid());
            baseUser.getBaseRole().setBasePermissionList(baseMapper.selPermByRId(param));
        }
        return baseUser;
    }

    @Override
    public Result resetPwd(HashMap param, HttpServletRequest request) {
        return null;
    }

    @Override
    public Result resetScreenPwd(HashMap param, HttpServletRequest request) {
        return null;
    }
}
