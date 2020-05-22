public class MyBenchmark extends Benchmark {
    public void timeMyOperation(int reps) {
      for (int i = 0; i < reps; i++) {
        int index = lss.linearStringSearch("mouse", lss.randomStrings);;
      }
   }
}