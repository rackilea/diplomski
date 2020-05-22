public class TestClass {

    @Test(groups="B")
    public void b1() {
        System.out.println("b1");
    }

    @Test(groups="B")
    public void b2() {
        System.out.println("b2");
    }

    @Test(groups="A", dependsOnGroups="B")
    public void a1() {
        System.out.println("a1");
    }

    @Test(groups="A", dependsOnGroups="B")
    public void a2() {
        System.out.println("a2");
    }

    @BeforeGroups(value="A", dependsOnGroups="B")
    public void setupA() {
        System.out.println("before");
    }
}