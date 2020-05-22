package org.sample;

import org.openjdk.jmh.annotations.*;
import java.lang.*;

public class MyBenchmark {

    @State(Scope.Benchmark)
    public static class ThreadState {
        volatile double x = 0;
        volatile double y = 0;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public double powx(ThreadState state) {
        state.x++;
        state.y += 0.5;
        return Math.pow(state.x, state.y);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public double pow3(ThreadState state) {
        state.x++;
        return Math.pow(state.x, 3);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public double pow2(ThreadState state) {
        state.x++;
        return Math.pow(state.x, 2);
    }
}