public class Test {
    public String m;

    public void testMethod(String x) {
        if (x.equals("h")) {
            m = "example1";
        } else if (x.equals("f")) {
            m = "example2";
        } else {
            m = "other";
        }
    }
}