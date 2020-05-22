// separate class
class Separate { byte[] x = new byte[1000]; }

public class Test1 {

    // non-static nested
    class Nested { byte[] x = new byte[1000]; }

    // static nested
    static class StaticNested { byte[] x = new byte[1000]; }

    static long getFreeMemory () {
        // waits for free memory measurement to stabilize
        long init = Runtime.getRuntime().freeMemory(), init2;
        int count = 0;
        do {
            System.out.println("waiting..." + init);
            System.gc();
            try { Thread.sleep(250); } catch (Exception x) { }
            init2 = init;
            init = Runtime.getRuntime().freeMemory();
            if (init == init2) ++ count; else count = 0;
        } while (count < 5);
        System.out.println("ok..." + init);
        return init;
    }

    Test1 () {

        Object[] s = new Object[10000];
        Object[] n = new Object[10000];
        Object[] t = new Object[10000];

        long init = getFreeMemory();

        for (int j = 0; j < 10000; ++ j)
            s[j] = new Separate();

        long afters = getFreeMemory();

        for (int j = 0; j < 10000; ++ j)
            n[j] = new Nested();

        long aftersn = getFreeMemory();

        for (int j = 0; j < 10000; ++ j)
            t[j] = new StaticNested();

        long aftersnt = getFreeMemory();

        System.out.println("separate:      " + -(afters - init) + " each=" + -(afters - init) / 10000);
        System.out.println("nested:        " + -(aftersn - afters) + " each=" + -(aftersn - afters) / 10000);
        System.out.println("static nested: " + -(aftersnt - aftersn) + " each=" + -(aftersnt - aftersn) / 10000);

    }

    public static void main (String[] args) {
        new Test1();
    }

}