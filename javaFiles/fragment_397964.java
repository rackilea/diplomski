public class CaptureTest {
    static List<IntSupplier> list;

    static IntSupplier foo(boolean b, Object o) {
        if (b) {
            return () -> 0;                      // line 20
        } else {
            int h = o.hashCode();
            return () -> h;                      // line 23
        }
    }

    static IntSupplier bar(boolean b, Object o) {
        if (b) {
            return () -> o.hashCode();           // line 29
        } else {
            int len = o.toString().length();
            return () -> len;                    // line 32
        }
    }

    static void run() {
        Object big = new byte[10_000_000];

        list = Arrays.asList(
            bar(false, big),
            bar(true,  big),
            foo(false, big),
            foo(true,  big));

        System.out.println("Done.");
    }

    public static void main(String[] args) throws InterruptedException {
        run();
        Thread.sleep(Long.MAX_VALUE); // stay alive so a heap dump can be taken
    }
}