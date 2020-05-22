public class MainAuthentication
{
    public static void main( String[] args )
    {
        ApplicationContext  applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/beans.xml");
        AuthFactory factory = applicationContext.getBean("authFactory", AuthFactory.class);
        Authenticator authenticator = factory.create();
        authenticator.authenticate(new MockSubject());
    }

    private static class MockSubject
    {
        @Override
        public String toString() {
            return "MockSubject";
        }
    }
}