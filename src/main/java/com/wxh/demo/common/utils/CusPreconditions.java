package com.wxh.demo.common.utils;

import java.util.function.Supplier;

/**
 * @author margot.wei
 * @date 2019/12/9 3:20 下午
 * @description 判决条件，
 * 由于guava 抛出的异常只能是RuntimeException所以做了修改可以抛出自定义异常
 *
 */
public class CusPreconditions {

    public static <X extends Throwable> void checkState(boolean b, Supplier<? extends X> exceptionSupplier) throws X {
        if (!b) {
            throw exceptionSupplier.get();
        }
    }
}
