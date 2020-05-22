@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
public class SO29378922 {
  @Param({"1", "100", "1000", "5000", "10000", "100000"}) int n;
  private final List<Integer> list = new ArrayList<>();
  @Setup public void populateList() {
    for (int i = 0; i < n; i++) list.add(0);
  }
  @Benchmark public Integer[] preSize() {
    return list.toArray(new Integer[n]);
  }
  @Benchmark public Integer[] resize() {
    return list.toArray(new Integer[0]);
  }
}