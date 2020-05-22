public class run {
  public static void main(String[] args) {
    System.loadLibrary("test");
    Method2Result ret = test.method2("foo", "bar");
    System.out.println(ret.getB() + " - " + ret.getS1() + ", " + ret.getS2());
  }
}