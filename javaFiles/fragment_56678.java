public class HelloworldcontrollerTest {
    private Helloworldcontroller hcontroller = new Helloworldcontroller();

    @Test
    public void testGreeting() {
        String h = hcontroller.sayHelloSB();
        Assert.assertEquals(h, "Hello,somebody");
    }
}