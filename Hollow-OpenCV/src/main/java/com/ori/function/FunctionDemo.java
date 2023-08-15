package com.ori.function;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionDemo<T, R> {

//    @FunctionalInterface
//    public interface SFunction<T,R>{
//        void reduce(T arg);
//    }

//    public void doSomething(Function<T, R> intFunc, Function<T, R> taskFunc, Function<T, R> desFunc, T params) {
    public void doSomething(Consumer<T> intFunc, T params) {
        intFunc.accept(params);
        intFunc.andThen(arg-> new Date());
    }
}