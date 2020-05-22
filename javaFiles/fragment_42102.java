public class Test {

    public static void main(String[] args) throws Exception {
        A a = new A();
        a.testMethod();
    }

    static class A {

        String test = "";
        String first = "";

        public void testMethod() {
            new Thread() {
                public void run() {
                    testThreadMethod();
                }
            }.start();
        }

        public void testThreadMethod() {
            System.out.println(first + " " + test);
        }
    }
}