package fibonacci.bench;

import fibonacci.mdl.ExplicitLocking;
import fibonacci.mdl.FibonacciGenerator;
import fibonacci.mdl.IntrinsicLocking;
import fibonacci.mdl.LockFree;
import fibonacci.mdl.STM;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.GenerateMicroBenchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.math.BigInteger;

/*
   Implementation notes:

   * This benchmark does not exhibit a steady state, which means
     we can not do timed runs. Instead, we have to time single
     invocations; therefore preset benchmark mode.

   * Each iteration should start from the pristine state,
     therefore we reinitialize in @Setup(Iteration).

   * Since we are interested in performance beyond the first
     invocation, we have to call several times and aggregate
     the time; this is why we have batchSize > 1. Note the
     performance might be different depending on given batch
     size.

   * Since we have to provide warmup, we do many iterations.

   * The performance is different run to run, because we are 
     measuring sometimes undeterministic thread allocations.
     JMH does it for us, hence multiple forks.

   * We don't want the profiles for difference FibonacciGenerator
     to mix up. JMH already takes care of that for us by forking
     each test.
     */

@BenchmarkMode(Mode.SingleShotTime)
@Warmup(iterations = 100, batchSize = JmhBench.BATCH_SIZE)
@Measurement(iterations = 100, batchSize = JmhBench.BATCH_SIZE)
@State(Scope.Benchmark)
public class JmhBench {

    public static final int BATCH_SIZE = 50000;

    private FibonacciGenerator explicitLock;
    private IntrinsicLocking intrinsicLock;
    private LockFree lockFree;
    private STM stm;

    @Setup(Level.Iteration)
    public void setup() {
        explicitLock = new ExplicitLocking();
        intrinsicLock = new IntrinsicLocking();
        lockFree = new LockFree();
        stm = new STM();
    }

    @GenerateMicroBenchmark
    public BigInteger stm() {
        return stm.next();
    }

    @GenerateMicroBenchmark
    public BigInteger explicitLock() {
        return explicitLock.next();
    }

    @GenerateMicroBenchmark
    public BigInteger intrinsicLock() {
        return intrinsicLock.next();
    }

    @GenerateMicroBenchmark
    public BigInteger lockFree() {
        return lockFree.next();
    }

}