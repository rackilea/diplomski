private static void initVelocity() throws Exception {
    java.util.Properties p = new java.util.Properties();
    p.setProperty("resource.loader", "class");
    p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    Velocity.init(p);
}