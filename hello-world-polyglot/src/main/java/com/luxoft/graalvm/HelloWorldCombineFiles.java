package com.luxoft.graalvm;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class HelloWorldCombineContexts {

    public static void main(String[] args) {
        try (Context context = Context.create().eval()) {
            Value function = context.eval("js", "x => x+1");
            assert function.canExecute();
            int x = function.execute(41).asInt();
            System.out.println(x); // 42
        }
    }
}
