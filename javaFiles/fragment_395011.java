class DoubleContainer {
   public double[] theArray;
}

public class SampleContainer {

   public void populate(DoubleContainer dc) {
      dc.theArray = new double[2];
      dc.theArray[0] = 42.0;
      dc.theArray[1] = 43.0;
   }

   public static void main(String[] args) {
      SampleContainer sc = new SampleContainer();

      // create the double[] container and call the API method
      DoubleContainer dc = new DoubleContainer();
      sc.populate(dc);

      System.err.println(java.util.Arrays.toString(dc.theArray));
   }
}