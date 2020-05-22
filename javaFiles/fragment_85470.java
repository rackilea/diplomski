public class FetchProfileInterceptor implements MethodInterceptor {

    private SessionFactory sessionFactory;
    private String fetchProfile;

    ... setters ...    

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Session s = sessionFactory.openSession(); // The transaction interceptor has already opened the session, so this returns it.
        s.enableFetchProfile(fetchProfile);
        try {
            return invocation.proceed();
        } finally {
            s.disableFetchProfile(fetchProfile);
        }
    }
}