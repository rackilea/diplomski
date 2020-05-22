// All classes in the web app share a ServletContext, so attribute names
// need to start with package names to prevent collisions.
private static final String SOME_ATTRIBUTE = TestResource.class.getName() + ".someAttribute";

@Override
public void contextInitialized(ServletContextEvent ctxt) {
    System.out.println("TestResource initialized!");

    String someString = "SET";
    System.out.println("someString has been set. someString: " + someString);

    ctxt.getServletContext().setAttribute(SOME_ATTRIBUTE, someString);
}

@GET
public void test(@Context ServletContext context) {
    System.out.println("someString " + context.getAttribute(SOME_ATTRIBUTE));
}