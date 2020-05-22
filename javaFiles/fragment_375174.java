public class AuthenticationFactory implements AuthFactory
{
    @Override
    public Authenticator create()
    {
        return new Authenticator("mocked-authenticator");
    }
}