public static void main(String[] args) throws Exception
{
    String jetty_home = System.getProperty("jetty.home","..");

    Server server = new Server(8080);

    WebAppContext webapp = new WebAppContext();
    webapp.setContextPath("/");
    webapp.setWar(jetty_home+"/webapps/test.war");
    server.setHandler(webapp);

    server.start();
    server.join();
}