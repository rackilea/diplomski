package stackoverflow;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
@Warmup(iterations = 2)
@Fork(1)
@Measurement(iterations = 10)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode({ Mode.AverageTime})
public class StreamBenchmark {
  private Set<String> s1;
  private Set<String> s2;

  @Setup
  public void setUp() {
    final Set<String> valuesForA = new HashSet<>();
    final Set<String> valuesForB = new HashSet<>();
    for (int i = 0; i < 1000; ++i) {
      valuesForA.add(Integer.toString(i));
      valuesForB.add(Integer.toString(1000 + i));
    }
    s1 = valuesForA;
    s2 = valuesForB;
  }

  @Benchmark
  public void stream_concat_then_collect_using_toSet(final Blackhole blackhole) {
    final Set<String> set = Stream.concat(s1.stream(), s2.stream()).collect(Collectors.toSet());
    blackhole.consume(set);
  }

  @Benchmark
  public void s1_collect_using_toSet_then_addAll_using_toSet(final Blackhole blackhole) {
    final Set<String> set = s1.stream().collect(Collectors.toSet());
    set.addAll(s2.stream().collect(Collectors.toSet()));
    blackhole.consume(set);
  }
}