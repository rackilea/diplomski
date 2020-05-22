public class Test1 extends BaseTest {
    @Test (priority = 1)
    public void test2() {
        System.out.println("printing test_2");
    }

    @Test(priority = 3)
    public void test3() {
        System.out.println("printing test_3");
    }
}