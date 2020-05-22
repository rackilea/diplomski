Server srv = new Server( port );

//  create context and handler for my servlets
Context ctx = new Context();
ServletHandler sh = new ServletHandler();

//  ... adding servlets here ...

//  create context and handler for static content
ServletHandler sh2 = new ServletHandler();
ServletHolder holder = new ServletHolder( new DefaultServlet() );
holder.setInitParameter("resourceBase", staticResourceBase);
sh2.addServletWithMapping( holder, "/*" );
staticContext.setContextPath(staticPathSpec);
staticContext.setServletHandler(sh2);

//  add both contexts to server
ContextHandlerCollection contexts = new ContextHandlerCollection();
contexts.setHandlers(new Handler[] { staticContext, ctx });
srv.setHandler(contexts);