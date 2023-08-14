package com.ori.function;

public class AbstractCall<R>{

    protected void addCondition(boolean condition, R column) {
        maybeDo(condition, () -> columnToSqlSegment(column));
    }
    protected final void maybeDo(boolean condition, DoSomething something) {
        if (condition) {
            something.doIt();
        }
    }

    protected final void columnToSqlSegment(R column) {
        System.out.println(columnToString(column));;
    }

    protected String columnToString(R column) {
        return (String) column;
    }
    @FunctionalInterface
    public interface DoSomething {

        void doIt();
    }
}
