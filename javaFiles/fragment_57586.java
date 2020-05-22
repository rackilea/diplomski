Server server = new Server(8080);

// Figure out what path to serve content from
ClassLoader cl = DemoProject.class.getClassLoader();
// We look for a file, as ClassLoader.getResource() is not
// designed to look for directories (we resolve the directory later)
URL f = cl.getResource("jsp-root/index.jsp");
if (f == null)
{
    throw new RuntimeException("Unable to find resource directory");
}

// Resolve file to directory
URI webRootUri = f.toURI().resolve("./").normalize();
System.err.println("WebRoot is " + webRootUri);

ServletContextHandler context = new ServletContextHandler();
context.setBaseResource(Resource.newResource(webRootUri));
context.setContextPath("/");
context.addServlet(Hello.class, "/hello");

// Must be added last, must be named "default" (JSP and Servlet requirement)
ServletHolder holderDef = new ServletHolder("default", DefaultServlet.class);
holderDef.setInitParameter("dirAllowed","false");
context.addServlet(holderDef,"/"); // Using "default" url-pattern (JSP and Servlet requirement)

HandlerList handlers = new HandlerList();
handlers.addHandler(context);
handlers.addHandler(new DefaultHandler()); // for errors when request doesn't match above handlers
server.setHandler(handlers);