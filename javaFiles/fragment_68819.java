public static HttpServer createServer() {
    final ResourceConfig rc = new ResourceConfig();
    rc.packages(true, "app");
    rc.register(ResponseCorsFilter.class);

    HttpServer server = GrizzlyHttpServerFactory.createHttpServer(
                               URI.create(BASE_URI), rc, false);
    server.getServerConfiguration().setAllowPayloadForUndefinedHttpMethods(true);
    return server;
}

public static void main(String[] args) throws IOException {
    final HttpServer server = createServer();
    server.start();
    System.out.println(String.format("Jersey app started with WADL available at "
            + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
    System.in.read();
    server.stop();
}