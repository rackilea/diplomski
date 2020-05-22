public class Test {
  public static void main(String[] args) {
    float f = (float)4.6006E-41;
    System.out.println(Integer.toHexString(Float.floatToIntBits(f)));
  }
}