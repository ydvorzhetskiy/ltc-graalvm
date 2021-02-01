package com.luxoft.graalvm.benchmarks;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Main {

    /*
     *
     */
    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
            // TODO: uncomment for each test
            .include(FibonacciBenchmark.class.getSimpleName())
            //.include(MatrixMulBenchmark.class.getSimpleName())
            //.include(DoubleParseBenchmark.class.getSimpleName())
            .forks(1)
            .build();

        new Runner(opt).run();
    }
}
