public class LoginControllerTest {
    public void testSomething() {
        // ...
        controller = new RealLoginController(fakeViewFactory);
        assertHasTag("td#row1", controller.getRenderedStuff());
        // ...
    }
}