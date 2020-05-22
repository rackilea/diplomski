public class App {
    private static final String WEBAPP_RESOURCES_LOCATION = "webapp";

    public static void main(String[] args) throws Exception {
        System.out.println(">> Running");

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/");

        URL webAppDir = Thread.currentThread().getContextClassLoader().getResource(WEBAPP_RESOURCES_LOCATION);
        webAppContext.setResourceBase(webAppDir.toURI().toString());

        // if setDescriptor set null or don't used jetty looking for /WEB-INF/web.xml under resource base 
//        webAppContext.setDescriptor(webAppDir.toURI().toString() + "web.xml");

        Server server = new Server(8080);
        server.setHandler(webAppContext);
        server.start();
        server.join();
    }
}