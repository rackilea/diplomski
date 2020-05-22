// sum all numbers from one to our given value
class StaticRecursive {
  public static int sumTo(int max) { return recursiveSum(); }
  private static int recursiveSum(int currentSum, int currentValue, int max)
  {
    if (currentValue == max) return currentSum;
    else return recursiveSum(currentSum + currentValue, currentValue + 1, max);
  }
}