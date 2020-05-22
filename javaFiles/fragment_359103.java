Context rootContext = getTomcatsRootContextFromSomewhere();
Servlet dispatcherServlet = getDispatcherServletFromSomewhere();

// add the dispatcher servlet to the root context
Tomcat.addServlet(rootContext, "mySpringService", dispatcherServlet);

// add a mapping to the dispatcher servlet
rootContext.addServletMapping("/api/*", "mySpringService");