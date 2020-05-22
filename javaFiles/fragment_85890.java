public class MyTest
{
     private static Server server;
     private static URI serverUri;

     @BeforeClass
     public static void startServer() throws Exception
     {
        server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(0); // let connector pick an unused port #
        server.addConnector(connector);

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        server.setHandler(context);

        // Serve capture servlet
        context.addServlet(new ServletHolder(new MyServlet()),"/my/*");

        // Start Server
        server.start();

        String host = connector.getHost();
        if (host == null)
        {
            host = "localhost";
        }
        int port = connector.getLocalPort();
        serverUri = new URI(String.format("http://%s:%d/",host,port));
    }

    @AfterClass
    public static void stopServer()
    {
        try
        {
            server.stop();
        }
        catch (Exception e)
        {
            e.printStackTrace(System.err);
        }
    }

    @Test
    public void testMe()
    {
        // Issue request to server
        URI requestUri = serverUri.resolve("/my/test");
        // assert the response
    }
}