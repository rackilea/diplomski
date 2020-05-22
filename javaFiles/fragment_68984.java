public class Test2 extends BaseTest {
    @Test(priority = 1)
    public void test4() {
        System.out.println("printing test_4");
    }

    @Test (priority = 3)
    public void test5() {
        System.out.println("printing test_5");
    }
}