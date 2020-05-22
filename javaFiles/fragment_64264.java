@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
@OperationsPerInvocation(1)
@Warmup(iterations = 5, time = 200, timeUnit=MILLISECONDS)
@Measurement(iterations = 30, time = 200, timeUnit=MILLISECONDS)
@State(Scope.Thread)
@Threads(1)
@Fork(1)
public class Measure
{
  private int arg;

  @Setup public void setup() {
    arg = (int) System.nanoTime();
  }

  @GenerateMicroBenchmark public String integerToString() {
    return Integer.toString(arg);
  }

  @GenerateMicroBenchmark public String stringValueOf() {
    return String.valueOf(arg);
  }

  @GenerateMicroBenchmark public String plus() {
    return ""+arg;
  }
}