public HttpServer startServer() {
    final WebServerResourceConfig rc = new WebServerResourceConfig();

    rc.register(Application.Server.ServerResponses.class);

    return GrizzlyHttpServerFactory.createHttpServer(URI.create(configurationService.RootWebServiceURI()), rc);
}