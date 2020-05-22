public class PartialResult {
   int startP;
   int endP;
   int[] storedValues;

   ... constructor

   public addValue(int p, int result) {
         storedValues[p +/- some offset] = result;
   }

   public void fill(int[] arr) {
      for (int p = startP; p < endP; p++)
         arr[p] = storedValues[p +/- some offset];
      }
   }
}