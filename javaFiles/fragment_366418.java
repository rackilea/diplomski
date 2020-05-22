package bench;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.ThreadLocalRandom;

@State(Scope.Thread)
public class RandomBench {
    double x = 1;

    @Benchmark
    public double multiply() {
        return x * Math.PI;
    }

    @Benchmark
    public double mathRandom() {
        return Math.random();
    }

    @Benchmark
    public double threadLocalRandom() {
        return ThreadLocalRandom.current().nextDouble();
    }
}