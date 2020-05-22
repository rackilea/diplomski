public class MainAppFIT extends TestFxBase {
    @Test
    public void verifyLogin() {
        // given started application and opened login dialog
        sleep(500);

        // when
        write("HelloWorld");
        type(TAB);
        write("password");
        clickOn("#loginButton");

        // then
        // TODO finish here with verification of actual result
    }
}