package com.test

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;

public class ControllerTest implements SparkApplication {

    private static SparkTestUtil sparkTestUtil;

    private static Server webServer;

    @Override
    public void init() {
         new Controller(...)
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
       sparkTestUtil = new SparkTestUtil(PORT);
       webServer = new Server();
       ServerConnector connector = new ServerConnector(webServer);
       connector.setPort(PORT);
       webServer.setConnectors(new Connector[] {connector});
       WebAppContext bb = new WebAppContext();
       bb.setServer(webServer);
       bb.setContextPath("/");
       bb.setWar("src/test/webapp/");
       webServer.setHandler(bb);
       webServer.start();
       (...)
    }

    @AfterClass
    public static void afterClass() throws Exception {
       webServer.stop();
       (...)
    }    

}