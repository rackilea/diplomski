tomcat = new Tomcat();
tomcat.setBaseDir(".");
tomcat.setPort(8084);
tomcat.addWebapp("/", System.getProperty("user.dir") + "/build/web");
tomcat.setHostname("localhost");
tomcat.enableNaming();
tomcat.start();