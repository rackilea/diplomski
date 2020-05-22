public class StringTest {
  public static void main(String[] args) {
  String s[] = new String[1];
  System.out.println("before: "+s[0]);
  updateString(s);
  System.out.println("after: " + s[0]);
}
  private static void updateString(String s[]) {
  s[0] = "New String";
  }
}