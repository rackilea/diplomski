final ServletContextHandler context = new ServletContextHandler();
final ServletHolder restEasyServlet = new ServletHolder(new HttpServletDispatcher());

context.setContextPath(CONTEXT_ROOT);

restEasyServlet.setInitParameter("resteasy.servlet.mapping.prefix", APPLICATION_PATH);
restEasyServlet.setInitParameter("javax.ws.rs.Application", JaxRsActivator.class.getCanonicalName());
context.addServlet(restEasyServlet, APPLICATION_PATH + "/*");

final ServletHolder defaultServlet = new ServletHolder("default", DefaultServlet.class); // the name "default" here is important
context.addServlet(defaultServlet, "/"); // this is not context-root, it's the default url-pattern

HandlerList handlers = new HandlerList();
handlers.addHandler(context);
handlers.addHandler(new DefaultHandler()); // to report errors that don't match the root context better

JETTY_SERVER.setHandler(handlers);
JETTY_SERVER.start();