Tomcat tomcat = new Tomcat();

// this defines Tomcat's working directory
File base = new File(System.getProperty("java.io.tmpdir"));
Context rootContext = tomcat.addContext("", base.getAbsolutePath());

// more configuration ...