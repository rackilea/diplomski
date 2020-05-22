public class EJBTestCase extends ServletTestCase {
protected InitialContext context;

public static final String userId = "demouser";


public EJBTestCase(String string) {
    super(string);
}

private InitialContext getInitialContext() throws NamingException {
  Hashtable env = new Hashtable();

  env.put(Context.SECURITY_PRINCIPAL, "username");
  env.put(Context.SECURITY_CREDENTIALS, "password");


     return new InitialContext(env);
}

public void setUp() throws Exception {
    super.setUp();

    context = getInitialContext();

}

public void tearDown() throws Exception {
    super.tearDown();

    context.close();
}

public EJBTestCase() {
    super();
}
}