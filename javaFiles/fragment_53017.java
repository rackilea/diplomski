String configFile =
    "/config/" +
    System.getenv().getOrDefault("XENV", "default") +
    ".conf";

InputStream config = MyClass.class.getResourceAsStream(configFile);

if (config == null) {
    throw new FileNotFoundException(
        "Cannot locate " + configFile + " in classpath");
}