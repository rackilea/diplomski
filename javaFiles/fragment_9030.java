#conf.properties:
key=value

#code
Properties conf = new Properties();
conf.load(new FileInputStream(new File("conf.properties")));
conf.getProperty("key"); // returns "value"