public class NumberConverter {
  private static final String[] AS_STRING = new String[] { "zero", "one", "two" };    

  public static String getTextualRepresentation(int n) {
    if (n>=AS_STRING.length || n<0) {
       throw new IllegalArgumentException("That number is not yet handled");
    }
    return AS_STRING[n];
  }
}