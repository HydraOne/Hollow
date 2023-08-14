package com.ori.function;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.function.Function;

@FunctionalInterface
public interface FunctionDemo<T, R> extends Function<T, R>, Serializable {
}