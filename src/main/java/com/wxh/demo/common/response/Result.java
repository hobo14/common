package com.wxh.demo.common.response;

import com.wxh.demo.common.response.enums.CommonResultEnum;
import com.wxh.demo.common.response.enums.IResult;

/**
 * @author margot.wei
 * @date 2019/12/2 7:35 下午
 * @description 通用响应结果
 */
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    private Result() {

    }

    private Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result success() {
        return new Result(CommonResultEnum.SUCCESS.getCode(), CommonResultEnum.SUCCESS.getMsg());
    }

    public static <T> Result success(T data) {
        return new Result(CommonResultEnum.SUCCESS.getCode(), CommonResultEnum.SUCCESS.getMsg(), data);
    }

    public static <T> Result faild() {
        return new Result(CommonResultEnum.FAILD.getCode(), CommonResultEnum.FAILD.getMsg());
    }

    public static <T> Result getResult(IResult result) {
        return new Result(result.getCode(), result.getMsg());
    }

    public static <T> Result getResult(Integer code, String msg) {
        return new Result(code, msg);
    }

    public static <T> Result getResult(Integer code, String msg, T data) {
        return new Result(code, msg, data);
    }


}
