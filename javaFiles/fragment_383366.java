public class CompTest {

  // fastest way to compare StringBuilder contents according to
  // http://stackoverflow.com/questions/11007387/what-is-an-efficient-way-to-compare-stringbuilder-objects
  static boolean contentEquals(StringBuilder sb1, StringBuilder sb2) {
    if (sb1.length() != sb2.length()) return false;
    for (int i = 0, len = sb1.length(); i < len; i++) {
      if (sb1.charAt(i) != sb2.charAt(i)) return false;
    }
    return true;
  }

  public static void main(String args[]) {

    StringBuilder fooSb = new StringBuilder("foo");
    StringBuilder barSb = new StringBuilder("foo");
    String foo = "foo";
    String bar = "foo";

    System.out.println(foo.equals(bar));
         // returns true
    System.out.println(fooSb.equals(barSb));
         // returns false, so cannot be used to check contents
    System.out.println(contentEquals(fooSb,barSb));
         // returns true

    long time;

    time = System.currentTimeMillis();
    for (int i = 0; i < 2000000000; i++) {
      if (foo.equals(bar)) continue;
    }
    System.out.println("str comparisons took " + (System.currentTimeMillis() - time) + " ms");

    time = System.currentTimeMillis();
    for (int i = 0; i < 2000000000; i++) {
      if (contentEquals(fooSb,barSb)) continue;
    }
    System.out.println("sb comparisons took " + (System.currentTimeMillis() - time) + " ms");

    /* repeat the test as we know JVM is warmed up by now */

    time = System.currentTimeMillis();
    for (int i = 0; i < 2000000000; i++) {
      if (foo.equals(bar)) continue;
    }
    System.out.println("str comparisons took " + (System.currentTimeMillis() - time) + " ms");

    time = System.currentTimeMillis();
    for (int i = 0; i < 2000000000; i++) {
      if (contentEquals(fooSb,barSb)) continue;
    }
    System.out.println("sb comparisons took " + (System.currentTimeMillis() - time) + " ms");

 }
}