Weld weld = new Weld();
try {
    WeldContainer container = weld.initialize();

    URI baseUri = UriBuilder.fromUri("http://localhost/").port(8080).build();
    ResourceConfig config = ResourceConfig.forApplicationClass(MyApplication.class);

    Server server = JettyHttpContainerFactory.createServer(baseUri, config);

    server.join();

} catch (Exception e) {
    e.printStackTrace();
} finally {
    weld.shutdown();
}