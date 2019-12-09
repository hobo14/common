package com.wxh.demo.common.exception.customize;

import com.wxh.demo.common.response.enums.IResult;

/**
 * @author margot.wei
 * @date 2019/12/2 7:56 下午
 * @description 业务层异常
 */
public class ServiceCheckException extends BaseException{

    public ServiceCheckException(IResult result) {
        super(result);
    }

    public ServiceCheckException(Integer code, String msg) {
        super(code, msg);
    }

    public ServiceCheckException(IResult result, Throwable cause) {
        super(result, cause);
    }

    public ServiceCheckException(IResult result, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(result, cause, enableSuppression, writableStackTrace);
    }
}
