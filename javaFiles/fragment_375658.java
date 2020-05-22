public static void main(String[] args) throws Exception
{
    Server server = new Server(8080);

    ServletContextHandler servletContext = new ServletContextHandler(ServletContextHandler.SESSIONS);
    servletContext.setContextPath("/");
    server.setHandler(servletContext);

    servletContext.addServlet(new ServletHolder(new HelloServlet()),"/*");

    servletContext.addFilter(TestFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));

    server.start();
    server.join();
}