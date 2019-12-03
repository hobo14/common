package com.wxh.demo.common.exception.handler;

import com.wxh.demo.common.exception.customize.BaseException;
import com.wxh.demo.common.response.Result;
import com.wxh.demo.common.response.enums.CommonResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author margot.wei
 * @date 2019/12/2 7:29 下午
 * @description 全局异常处理
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({BaseException.class})
    public Result baseExceptionHandler(HttpServletRequest request, BaseException e) {
        log.error("---BusinessException Handler---Host {} invokes url {} ERROR: {}", new Object[]{request.getRemoteHost(), request.getRequestURL(), e.getMessage()}, e);
        return Result.getResult(e.getCode(), e.getMessage());
    }

    public Result defaultExceptionHandler(HttpServletRequest request, Exception e) {
        log.error("---Exception Handler---Host {} invokes url {} ERROR: {}", new Object[]{request.getRemoteHost(), request.getRequestURL(), e.getMessage()}, e);
        return Result.getResult(CommonResultEnum.SYSTEM_EXCEPTION);
    }

    @ExceptionHandler({BindException.class})
    public Result bindExceptionHandler(HttpServletRequest request, Exception e) {

        StringBuilder message = new StringBuilder();
        List<FieldError> fieldErrorList = ((BindException) e).getFieldErrors();
        fieldErrorList.stream().forEach(fieldError -> {
            if (fieldError != null && fieldError.getDefaultMessage() != null) {
                message.append(fieldError.getDefaultMessage()).append(" ");
            }
        });

        log.error("---Exception Handler---Host {} invokes url {} ERROR: {}", new Object[]{request.getRemoteHost(), request.getRequestURL(), message.toString()});

        return Result.getResult(CommonResultEnum.PARAM_CHECK_EXCEPTION.getCode(), message.toString());
    }

}
