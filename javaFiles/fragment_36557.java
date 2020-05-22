public class Test1 {

    Test1() {
        throw new RuntimeException();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalized");
    }

    public static void main(String[] args) throws Exception {
        try {
            new Test1();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        System.gc();
        Thread.sleep(1000);
    }
}