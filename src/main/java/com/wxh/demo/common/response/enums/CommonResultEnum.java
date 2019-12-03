package com.wxh.demo.common.response.enums;


public enum CommonResultEnum implements IResult {
    //成功
    SUCCESS(200, "success"),
    FAILD(500, "FAILD"),
    SYSTEM_EXCEPTION(501, "系统异常"),
    PARAM_CHECK_EXCEPTION(600, "参数校验异常");
    private Integer code;
    private String msg;

    CommonResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
