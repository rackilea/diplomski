import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@Fork(3)
@BenchmarkMode(Mode.AverageTime)
@Measurement(iterations = 10, timeUnit = TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Threads(1)
@Warmup(iterations = 5, timeUnit = TimeUnit.NANOSECONDS)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MyBenchmark {

  Blackhole bh = new Blackhole();

  @Benchmark
  public void testRegexLoop() {
    Pattern pattern = Pattern.compile("\\((-?\\d+),(-?\\d+)\\)");
    Matcher matcher = pattern.matcher("(8,0),(0,-1),(7,-2),(1,1)");

    while (matcher.find()) {
      int x = Integer.parseInt(matcher.group(1));
      int y = Integer.parseInt(matcher.group(2));
      bh.consume(x);
      bh.consume(y);
    }
  }

  @Benchmark
  public void testRegexWhole() {
    Pattern pattern = Pattern
        .compile("\\((-?\\d+),(-?\\d+)\\),\\((-?\\d+),(-?\\d+)\\),\\((-?\\d+),(-?\\d+)\\),\\((-?\\d+),(-?\\d+)\\)");
    Matcher matcher = pattern.matcher("(8,0),(0,-1),(7,-2),(1,1)");
    matcher.find();
    bh.consume(Integer.parseInt(matcher.group(1)));
    bh.consume(Integer.parseInt(matcher.group(2)));
    bh.consume(Integer.parseInt(matcher.group(3)));
    bh.consume(Integer.parseInt(matcher.group(4)));
    bh.consume(Integer.parseInt(matcher.group(5)));
    bh.consume(Integer.parseInt(matcher.group(6)));
    bh.consume(Integer.parseInt(matcher.group(7)));
    bh.consume(Integer.parseInt(matcher.group(8)));
  }

  @Benchmark
  public void testReplaceSplit() {
    String s = "(8,0),(0,-1),(7,-2),(1,1)";
    String[] values = s.replaceAll("[()]", "").split(",");
    int[] intValues = new int[values.length];
    for (int i = 0; i < values.length; i++) {
      intValues[i] = Integer.parseInt(values[i]);
    }
    bh.consume(intValues);
  }
}