private void setupJspHandler(WebAppContext context) {

    //Ensure the jsp engine is initialized correctly
    JettyJasperInitializer sci = new JettyJasperInitializer();

    ServletContainerInitializersStarter sciStarter = new ServletContainerInitializersStarter(context);
    ContainerInitializer initializer = new ContainerInitializer(sci, null);
    List<ContainerInitializer> initializers = new ArrayList<ContainerInitializer>();
    initializers.add(initializer);
    context.setAttribute("org.eclipse.jetty.containerInitializers", initializers);
    context.addBean(sciStarter, true);

    // Set Classloader of Context to be sane (needed for JSTL)
    // JSP requires a non-System classloader, this simply wraps the
    // embedded System classloader in a way that makes it suitable
    // for JSP to use
    ClassLoader jspClassLoader = new URLClassLoader(new URL[0], this.getClass().getClassLoader());
    context.setClassLoader(jspClassLoader);

    // Add JSP Servlet (must be named "jsp")
    ServletHolder holderJsp = new ServletHolder("jsp",JspServlet.class);
    holderJsp.setInitOrder(0);
    holderJsp.setInitParameter("logVerbosityLevel","INFO");
    holderJsp.setInitParameter("fork","false");
    holderJsp.setInitParameter("xpoweredBy","false");
    holderJsp.setInitParameter("compilerTargetVM","1.7");
    holderJsp.setInitParameter("compilerSourceVM","1.7");
    holderJsp.setInitParameter("keepgenerated","true");
    context.addServlet(holderJsp, "*.jsp");
}