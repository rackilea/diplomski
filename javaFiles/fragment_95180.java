// https://stackoverflow.com/questions/32500628/when-to-use-local-variable-instead-of-method
public class Inlining {
public static int calledStaticMethod() {
    return 0;
}

public static void dumpValue(Object o) { // Fool compiler/JVM that value is going somewhere

}

public static void main(String[] args) {
    float iterations = Benchmark.iterationsFor10sec(new Benchmark("cacheCall") {
        @Override
        public void execute(long iterations) {
            int i1,i2,i3 = 0;
            for (int i = 0; i < iterations; i++) {
                int localVar = calledStaticMethod();
                i1 = localVar;
                i2 = i1 + localVar;
                i3 = i2 + localVar;
            }
            dumpValue((Integer)i3);
        }
    });
    System.out.printf("cacheCall: %10.0f\n", iterations);

    iterations = Benchmark.iterationsFor10sec(new Benchmark("staticCall") {
        @Override
        public void execute(long iterations) {
            int i1,i2,i3 = 0;
            for (int i = 0; i < iterations; i++) {
                i1 = calledStaticMethod();
                i2 = i1 + calledStaticMethod();
                i3 = i2 + calledStaticMethod();
            }
            dumpValue((Integer)i3);
        }
    });
    System.out.printf("staticCall: %10.0f\n", iterations);

    // borderline for inlining, as instance methods might be overridden.
    iterations = Benchmark.iterationsFor10sec(new Benchmark("instanceCall") {
        public int calledInstanceMethod() { return calledStaticMethod(); }
        @Override
        public void execute(long iterations) {
            int i1,i2,i3 = 0;
            for (int i = 0; i < iterations; i++) {
                i1 = calledInstanceMethod();
                i2 = i1 + calledInstanceMethod();
                i3 = i2 + calledInstanceMethod();
            }
            dumpValue((Integer)i3);
        }
    });
    System.out.printf("instanceCall: %10.0f\n", iterations);
}

}

abstract class Benchmark {
private String name;
public Benchmark(String s) { name = s; }
public String getName() { return name; }
public abstract void execute(long iterations);
public static float iterationsFor10sec(Benchmark bm) {
    long t0 = System.nanoTime();
    long ellapsed = 0L;
    // Calibration. Run .5-1.0 seconds. Estimate iterations for .1 sec
    final long runtimeCalibrate = (long)0.5e9; // half second
    long iterations = 1L;
    while (ellapsed < runtimeCalibrate) {
        bm.execute(iterations);         
        iterations *= 2;
        ellapsed = System.nanoTime() - t0;
    }
    iterations--; // Actually we executed 2^N - 1.
    int innerIterations = (int) ((double)iterations * 1e8 /* nanos/inner */ / ellapsed);
    if (innerIterations < 1) { innerIterations = 1; }
    // run rest of the time
    final long runtimeTotal = (long)1e10;
    // outer loop
    while (ellapsed < runtimeTotal) {
        // delegate benchmark contains inner loop
        bm.execute(innerIterations);
        iterations += innerIterations;
        ellapsed = System.nanoTime() - t0;
    }
    // execution time might exceed 10 seconds. rectify number of iterations
    return (float)iterations * 1e10f /* nanos total */ / (float)ellapsed;

}
}