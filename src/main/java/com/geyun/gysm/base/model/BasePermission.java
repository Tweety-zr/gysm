package com.geyun.gysm.base.model;

import lombok.Data;

/**
 * @author 崔世良
 * @date 2020/1/20 13:41
 * @editer 崔世良
 * @editdate 2020/1/20 13:41
 * @description 权限
 */
@Data
public class BasePermission {

    /**
     * 权限id
     */
    private String strGuid;
    /**
     * 权限名
     */
    private String strPermName;
    /**
     * 权限说明
     */
    private String description;

}
