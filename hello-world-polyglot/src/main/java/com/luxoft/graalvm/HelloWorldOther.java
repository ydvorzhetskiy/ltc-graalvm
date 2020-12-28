package com.luxoft.graalvm;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class HelloWorldOther {

    public static void main(String[] args) {
        returnValueFromR();
        returnValueFromRuby();
        returnValueFromPython();
    }

    private static void returnValueFromR() {
        try (Context context = Context.newBuilder()
            .allowAllAccess(true)
            .build()
        ) {
            Value function = context.eval("R", "function(x) x + 1");
            int x = function.execute(41).asInt();
            System.out.println(x); // 42
        }
    }

    private static void returnValueFromRuby() {
        try (Context context = Context.create()) {
            Value function = context.eval("ruby", "proc { |x| x + 1 }");
            int x = function.execute(41).asInt();
            System.out.println(x); // 42
        }
    }

    private static void returnValueFromPython() {
        try (Context context = Context.create()) {
            Value function = context.eval("python", "lambda x: x + 1");
            int x = function.execute(41).asInt();
            System.out.println(x); // 42
        }
    }
}
