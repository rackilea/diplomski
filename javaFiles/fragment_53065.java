@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestMethodOrder {

    @Test
    public void testA() {
        System.out.println("first");
    }
    @Test
    public void testC() {
        System.out.println("third");
    }
    @Test
    public void testB() {
        System.out.println("second");
    }
}