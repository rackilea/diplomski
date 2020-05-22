// default to DEV
 String profile = "dev"
 if (System.getProperty("ENV") != null) {
    profile = System.getProperty("ENV");
 }
 Properties prop = new Properties();
 ClassLoader loader = Thread.currentThread().getContextClassLoader();
 InputStream in = loader.getResourceAsStream(fileName + "_" + profile + ".properties");