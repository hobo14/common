package com.wxh.demo.common.exception.customize;

import com.wxh.demo.common.response.enums.IResult;

/**
 * @author margot.wei
 * @date 2019/12/2 7:50 下午
 * @description 基础异常类
 */
public class BaseException extends RuntimeException {
    private Integer code;

    /**
     * 尽量不要使用该方法，使用枚举参数
     * @param code
     * @param msg
     */
    public BaseException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public BaseException(IResult result) {
        super(result.getMsg());
        this.code = result.getCode();
    }

    public BaseException(IResult result, Throwable cause) {
        super(result.getMsg(), cause);
        this.code = result.getCode();
    }

    public BaseException(IResult result, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(result.getMsg(), cause, enableSuppression, writableStackTrace);
        this.code = result.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
