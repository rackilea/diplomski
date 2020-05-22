public class ForkJoinCalculator extends RecursiveTask<Double> {

   public static final long THRESHOLD = 1_000_000;

   private final SequentialCalculator sequentialCalculator;
   private final double[] numbers;
   private final int start;
   private final int end;

   public ForkJoinCalculator(double[] numbers, SequentialCalculator sequentialCalculator) {
     this(numbers, 0, numbers.length, sequentialCalculator);
   }

   private ForkJoinCalculator(double[] numbers, int start, int end, SequentialCalculator sequentialCalculator) {
     this.numbers = numbers;
     this.start = start;
     this.end = end;
     this.sequentialCalculator = sequentialCalculator;
   }

   @Override
   protected Double compute() {
     int length = end - start;
     if (length <= THRESHOLD) {
         return sequentialCalculator.computeSequentially(numbers, start, end);
     }
     ForkJoinCalculator leftTask = new ForkJoinCalculator(numbers, start, start + length/2, sequentialCalculator);
     leftTask.fork();
     ForkJoinCalculator rightTask = new ForkJoinCalculator(numbers, start + length/2, end, sequentialCalculator);
     Double rightResult = rightTask.compute();
     Double leftResult = leftTask.join();
     return leftResult + rightResult;
  }
}