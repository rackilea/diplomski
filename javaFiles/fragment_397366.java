final ResourceConfig rc = new PackagesResourceConfig("com.twins.engine");
final Map<String, Object> config = new HashMap<String, Object>();
config.put("com.sun.jersey.api.json.POJOMappingFeature", true);
rc.setPropertiesAndFeatures(config);
HttpServer server = HttpServerFactory.create(BASE_URI,rc);
server.setExecutor(null);
server.start();