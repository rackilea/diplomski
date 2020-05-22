public class Main {

  public static void main(String ...args) {
    CustomJettyServerFactory customJettyServerFactory = new CustomJettyServerFactory();
    EmbeddedServers.add(
        EmbeddedServers.Identifiers.JETTY, 
        new EmbeddedJettyFactory(customJettyServerFactory));
  }
}

class CustomJettyServerFactory implements JettyServerFactory {
  @Override
  public Server create(int maxThreads, int minThreads, int threadTimeoutMillis) {
    Server server = new Server();
    server.setAttribute("org.eclipse.jetty.server.Request.maxFormContentSize", 1000000);
    return server;
  }

  @Override
  public Server create(ThreadPool threadPool) {
    return null;
  }
}