@Override
public void contextDestroyed(ServletContextEvent sce) {        
    tcpServer.close();
    serverThread.interrupt();
    ServletContextListener.super.contextDestroyed(sce);
}