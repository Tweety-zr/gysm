package com.geyun.gysm.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 崔世良
 * @date 2020/1/19 16:20
 * @editer 崔世良
 * @editdate 2020/1/19 16:20
 * @description
 */
@Data
public class Result {
    private Integer resultCode;

    private String resultMsg;

    private Map<String,Object> resultData = new HashMap<String,Object>();

    /**
     * 成功
     * @return
     */
    public static Result success(){
        Result result = new Result();
        result.setResultCode(ResultEnums.TRUE_200.getCode());
        result.setResultMsg(ResultEnums.TRUE_200.getMessage());
        return result;
    }

    public Result add(String key,Object value){
        this.getResultData().put(key, value);
        return this;
    }

    /**
     * 带参数的失败
     * @return
     */
    public static Result fail(String msg){
        Result result = new Result();
        result.setResultCode(ResultEnums.FALSE_300.getCode());
        result.setResultMsg(msg);
        return result;
    }

}
