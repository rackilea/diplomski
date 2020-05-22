public static double varianceForkJoin(double[] population){
   final ForkJoinPool forkJoinPool = new ForkJoinPool();
   double total = forkJoinPool.invoke(new ForkJoinCalculator(population, new SequentialCalculator() {
     @Override
     public double computeSequentially(double[] numbers, int start, int end) {
       double total = 0;
       for (int i = start; i < end; i++) {
         total += numbers[i];
       }
       return total;
     }
  }));
  final double average = total / population.length;
  double variance = forkJoinPool.invoke(new ForkJoinCalculator(population, new SequentialCalculator() {
    @Override
    public double computeSequentially(double[] numbers, int start, int end) {
      double variance = 0;
      for (int i = start; i < end; i++) {
        variance += (numbers[i] - average) * (numbers[i] - average);
      }
      return variance;
    }
 }));
 return variance / population.length;
}