public class InnerEx {
    public static final void main(String[] args) {
        new InnerEx().test("hi");
    }

    private void test(String arg) {
        final String localVar = arg;

        Runnable r = new Runnable() {
            public void run() {
                System.out.println(localVar);
            }
        };
        r.run();
    }
}