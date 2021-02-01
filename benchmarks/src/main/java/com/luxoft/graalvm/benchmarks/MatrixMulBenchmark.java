package com.luxoft.graalvm.benchmarks;

import org.openjdk.jmh.annotations.*;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10, time = 1)
@Measurement(iterations = 10, batchSize = 1)
@Fork(value = 2, warmups = 1)
@State(Scope.Thread)
public class MatrixMulBenchmark {

    private double[][] result = {
        new double[]{1d, 1d},
        new double[]{0d, 1d}
    };

    private double[][] a = {
        new double[]{1d, 0.5d},
        new double[]{0d, 1d}
    };

    // tested function
    public static double[][] matrixMul(double[][] firstMatrix, double[][] secondMatrix) {
        double[][] result = new double[firstMatrix.length][secondMatrix[0].length];
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = multiplyMatricesCell(firstMatrix, secondMatrix, row, col);
            }
        }
        return result;
    }

    private static double multiplyMatricesCell(double[][] firstMatrix, double[][] secondMatrix, int row, int col) {
        double cell = 0;
        for (int i = 0; i < secondMatrix.length; i++) {
            cell += firstMatrix[row][i] * secondMatrix[i][col];
        }
        return cell;
    }

    @Benchmark
    public void benchmark() {
        int n = 5000000;
        for (int i = 0; i < n; ++i) {
            result = matrixMul(result, a);
        }
    }
}
