public class run { 
  public static void main(String[] argv) {
    String s = "ho\0la";
    System.out.println(s.getBytes().length);

    System.loadLibrary("test");
    Bar b = new Bar();
    byte[] bytes = b.foo();
    s = new String(bytes);
    System.out.println(s + " - " + s.length());
    assert(s.charAt(2) == 0);
  }
}