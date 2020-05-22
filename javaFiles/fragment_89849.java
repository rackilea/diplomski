public class TimingTest {
    @Test public void test1() {
        System.out.println("test1");
        sleep(1000);
    }

    @Test public void test2() {
        System.out.println("test2");
        sleep(2000);
    }

    @After public void after() {
        System.out.println("after");
        sleep(3000);
    }

    @AfterClass public static void afterClass() {
        System.out.println("afterClass");
        sleep(5000);
    }

    private static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}