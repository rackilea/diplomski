public class Step {

   private int value;

   public Step(int value) {
      if (value <= 0) throw new IllegalArgumentException("Step cannot be lower than 1");
      this.value = value;
   }

   public int getValue() { return value; }
}


public static int[] createMonotoneIncreasingArray(int start, int end, Step step) {
    int[] resultArray = new int[(end - start) / step.getValue()];
    for (int i = 0; i < resultArray.length; i++) resultArray[i] = i * step.getValue() + start;
    return resultArray;
}