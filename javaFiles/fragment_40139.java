InitialContext ctx;
try {
    Properties props = new Properties();
    props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
    props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
    props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
    props.setProperty(Context.STATE_FACTORIES, "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
    props.setProperty(Context.URL_PKG_PREFIXES, "com.sun.enterprise.naming");
    System.setProperty("java.security.auth.login.config", "./jaas.config");
    ProgrammaticLogin pl = new ProgrammaticLogin();
    boolean loginSuccessfull = pl.login("username", "password".toCharArray());
    ctx = new InitialContext(props);
    HelloBean helloBean = (HelloBean) ctx.lookup("java:global/HelloApp/HelloBeanImpl!app.hello.HelloBean");
    resp.getOutputStream().print(helloBean.sayHelloTo("user"));
} catch (Exception e) {
    e.printStackTrace(System.err);
}