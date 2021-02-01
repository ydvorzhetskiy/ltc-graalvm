package com.luxoft.graalvm.benchmarks;

import org.openjdk.jmh.annotations.*;

import java.util.OptionalDouble;
import java.util.Random;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 10, batchSize = 1)
@Fork(value = 2, warmups = 1)
@State(Scope.Thread)
public class DoubleParseBenchmark {

    @Benchmark
    public void benchmark() {
        Random random = new Random();
        OptionalDouble avg = random.ints(10000000, 0, 1000)
            .parallel()
            .mapToObj(i -> i + "." + i)
            .mapToDouble(Double::parseDouble)
            .average();
    }
}
