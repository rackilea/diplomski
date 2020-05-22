public class TestLoginAction extends MockStrutsTestCase {
    public TestLoginAction(String testName) { super(testName); }

    public void testSuccessfulLogin() {
       setRequestPathInfo("/login");
       addRequestParameter("username","deryl");
       addRequestParameter("password","radar");
       actionPerform();
       verifyForward("success");
    }
}