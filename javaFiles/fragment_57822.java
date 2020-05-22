public class AuthenticationModuleTest
{
    @Tested AuthenticationModule authentication;
    @Mocked AuthenticationServicePort authenticationService;
    @Mocked AuthenticationService port;

    @Test
    public void validateUser()
    {
        final String userName = "tester";
        final String password = "12345";
        authentication.setUserName(userName);
        authentication.setPassword(password);
        new Expectations() {{ port.login(userName, password); result = true; }};

        boolean validated = authentication.validateUser();

        assertTrue(validated);
    }
}