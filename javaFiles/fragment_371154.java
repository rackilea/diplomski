class ParentOfSample {
    void testingOverriding(String s) {
        System.out.println("Parent..");
    }
}

public class Sample extends ParentOfSample {
    static void doSomething(InputStream is) {
        System.out.println("is");
    }

    static void doSomething(OutputStream os) {
        System.out.println("os");
    }

    void testingOverriding(String s) {
        System.out.println("Sample..");
    }

    public static void main(String args[]) {
        ParentOfSample s = new Sample();
        s.testingOverriding(null);
    }
}