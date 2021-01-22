package com.luxoft.graalvm.benchmarks;

import org.openjdk.jmh.annotations.*;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 10, batchSize = 1)
@Fork(value = 2, warmups = 1)
@State(Scope.Thread)
public class FibonacciBenchmark {

    // tested function
    public static long fib(long n) {
        if (n <= 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    @Benchmark
    public void benchmark() {
        fib(42);
    }
}
