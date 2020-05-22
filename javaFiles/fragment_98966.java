public class Main {
    public static void main(String[] args) {
        try {
            // create custom ObjectMapper
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            // create JsonProvider to provide custom ObjectMapper
            JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
            provider.setMapper(mapper);

            // configure REST service
            ResourceConfig rc = new ResourceConfig();
            rc.register(ExampleResource.class);
            rc.register(provider);

            // create Grizzly instance and add handler
            HttpHandler handler = ContainerFactory.createContainer(
                    GrizzlyHttpContainer.class, rc);
            URI uri = new URI("http://0.0.0.0:8080/");
            HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri);
            ServerConfiguration config = server.getServerConfiguration();
            config.addHttpHandler(handler, "/");

            // start
            server.start();
            System.in.read();

        } catch (ProcessingException | URISyntaxException | IOException e) {
            throw new Error("Unable to create HTTP server.", e);
        }
    }
}