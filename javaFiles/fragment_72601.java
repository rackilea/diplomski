class InstanceRecursive {
  private int max;
  private int sum;
  public int sumTo(int max) {
    this.max = max;
    this.sum = 0;
    return recursiveSum(0);
  }
  public void recursiveSum(int currentValue)
  {
    if (currentValue == this.max) return;
    else {
      sum += currentValue;
      recursiveSum(currentValue + 1);
    }
  }