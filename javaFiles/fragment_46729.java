public class TestKlass {
    public TestKlass() {
        System.out.println("Java: TestKlass::TestKlass()");
    }

    public void finalize() {
        System.out.println("Java: TestKlass::finalize()");
    }

    public static void force_gc() {
        System.out.println("Java: TestKlass::force_gc()");

        System.gc();
        System.runFinalization();
    }
}