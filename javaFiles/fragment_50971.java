public class main {

public static void main(String[] args) {

      MWNumericArray n = null;
      Object[] result = null;
      Class1 theMagic = null;

      try
      {
         n = new MWNumericArray(Double.valueOf(5),MWClassID.DOUBLE);

         theMagic = new Class1();

         result = theMagic.makesqr(1, n);
         System.out.println(result[0]);
      }
      catch (Exception e)
      {
         System.out.println("Exception: " + e.toString());
      }
      finally
      {
         MWArray.disposeArray(n);
         MWArray.disposeArray(result);
         theMagic.dispose();
      }
}