protected RESTServer(int port, Class<?> api, String path) {
        this.server = new org.eclipse.jetty.server.Server(port);
        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setResourceBase("src/main/webapp");
        ServletHolder restServlet = webAppContext.addServlet(ServletContainer.class, "/rest/*");
        restServlet.setInitOrder(0);
        restServlet.setInitParameter(JERSEY_PROVIDER, api.getCanonicalName());
        HandlerCollection handlers = new HandlerCollection();
        handlers.addHandler(webAppContext);
        server.setHandler(handlers);
}