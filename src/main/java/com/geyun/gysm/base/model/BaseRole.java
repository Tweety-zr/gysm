package com.geyun.gysm.base.model;

import lombok.Data;

import java.util.List;

/**
 * @author 崔世良
 * @date 2020/1/20 13:38
 * @editer 崔世良
 * @editdate 2020/1/20 13:38
 * @description 角色实体
 */
@Data
public class BaseRole {

    /**
     * 角色id
     */
    private String strGuid;
    /**
     * 角色名
     */
    private String strRoleName;
    /**
     * 角色权限
     */
    private List<BasePermission> basePermissionList;
}
