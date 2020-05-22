public static double calcStdDev (List<Double> numbers, double variance) {
  double sumOfNumbers = 0;
  double sumOfSquares = 0;
  for(double number : numbers) {
    sumOfNumbers += number;
    sumOfSquares += number * number;
}
... and instead of calculating count, you simply have
int numberOfNumbers = numbers.size();
... and now, do your math