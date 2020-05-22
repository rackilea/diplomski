public class Benchmark1 extends SimpleBenchmark {
  public void timeFoo(int reps) {
    for (int i = 0; i < reps; i++) {
      foo();
    }
  }
}