static long sum(List<Number> numbers) {
   long summation = 0;
   for(Number number : numbers) {
      summation += number.longValue();
   }
   return summation;
}