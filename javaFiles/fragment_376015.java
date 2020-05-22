@Warmup(iterations = 10, time = 200, timeUnit = MILLISECONDS)
@Measurement(iterations = 20, time = 500, timeUnit = MILLISECONDS)
@BenchmarkMode(Mode.Throughput)
public class MyBenchmark {

  public static final String EMPTY_STRING = "   "; // 3 whitespaces
  public static final String NOT_EMPTY_STRING = "  a "; // 3 whitespaces with a in the middle

  @Benchmark
  public void testEmptyTrim() {
    EMPTY_STRING.trim();
  }

  @Benchmark
  public void testEmptyStrip() {
    EMPTY_STRING.strip();
  }

  @Benchmark
  public void testNotEmptyTrim() {
    NOT_EMPTY_STRING.trim();
  }

  @Benchmark
  public void testNotEmptyStrip() {
    NOT_EMPTY_STRING.strip();
  }

}