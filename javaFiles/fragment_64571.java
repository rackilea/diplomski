public class run {
  public static void main(String[] args) {
    String[] out1 = new String[1];
    String[] out2 = new String[1];
    boolean retb = test.method2("foo", "bar", out1, out2);
    System.out.println(retb + " - " + out1[0] + ", " + out2[0]);
  }
}