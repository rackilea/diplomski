Tomcat tomcat = new Tomcat();
tomcat.setBaseDir("temp");
tomcat.setPort(8080);
tomcat.enableNaming();
tomcat.getConnector(); // Tomcat 9 we need to get the connector. it not by default.

String contextPath = "/Test";     
String warFilePath = "D:\\Test\\embedded\\Test.war";

tomcat.getHost().setAppBase(".");
StandardContext ctx = (StandardContext) tomcat.addWebapp(contextPath, warFilePath);
((StandardJarScanner) ctx.getJarScanner()).setScanAllDirectories(true);
((StandardJarScanner) ctx.getJarScanner()).setScanAllFiles(true);
((StandardJarScanner) ctx.getJarScanner()).setScanClassPath(true);

tomcat.start();
tomcat.getServer().await();