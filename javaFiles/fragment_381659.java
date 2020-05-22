public class JStatTest {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; ++i) {
            System.gc();
            System.out.println("Wait...");
            Thread.sleep(1000);
        }
        Thread.sleep(100_000);
    }

}