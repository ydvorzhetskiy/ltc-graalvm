package com.luxoft.graalvm;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello Java!");
        simpleJsRun();
        runJsFunction();
        accessLanguagesDirectly();
    }

    private static void simpleJsRun() {
        try (Context context = Context.create()) {
            context.eval("js", "print('Hello JavaScript!');");
        }
    }

    private static void runJsFunction() {
        try (Context context = Context.create()) {
            Value function = context.eval("js", "x => x+1");
            assert function.canExecute();
            int x = function.execute(41).asInt();
            System.out.println(x); // 42
        }
    }

    private static void accessLanguagesDirectly() {
        try (Context context = Context.create()) {
            Value result = context.eval("js",
                "({ " +
                    "id   : 42" +
                    "})");
            assert result.hasMembers();

            int id = result.getMember("id").asInt();
            System.out.println(id); // 42
        }
    }
}
