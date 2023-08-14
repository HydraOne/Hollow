package com.ori.function;

import java.util.function.Function;

public class CallFunctionDemo<T> {

    public void print(String arg){
        System.out.println(arg);
    }

    public void print(FunctionDemo<T,?> arg){
        columnToString(arg);
    }

    protected void columnToString(FunctionDemo<T,?> arg) {
        new AbstractCall<Object>().addCondition(true,arg);
    }

}