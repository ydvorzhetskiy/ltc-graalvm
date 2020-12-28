package com.luxoft.graalvm;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.IOException;

public class HelloWorldCombineFiles {

    public static void main(String[] args) throws IOException {
        try (Context context = Context.create()) {
            context.eval(Source.newBuilder("js",
                HelloWorldCombineFiles.class.getClassLoader()
                    .getResource("constant.js")
            ).build());
            context.eval(Source.newBuilder("js",
                HelloWorldCombineFiles.class.getClassLoader()
                    .getResource("increment.js")
            ).build());
            Value value = context.eval("js", "incrementFunction(constantFunction())");
            int x = value.asInt();
            System.out.println(x); // 43
        }
    }
}
