String resourceName = "myconf.properties"; // could also be a constant
ClassLoader loader = Thread.currentThread().getContextClassLoader();
Properties props = new Properties();
try(InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
    props.load(resourceStream);
}
// use props here ...