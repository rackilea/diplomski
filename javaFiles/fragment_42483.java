public final class ExtensionPluginLifecycle implements SPIPluginLifecycle {

    private WebServer webServer;
    private CustomFilter customFilter;

    @Override
    public Collection<Injectable<?>> start(final NeoServer neoServer) {
        webServer = getWebServer(neoServer);

        addFilters();
    }

    @Override
    public void stop() {
        removeFilters();
    }

    @Override
    public Collection<Injectable<?>> start(final GraphDatabaseService graphDatabaseService,
                                         final Configuration config) {
        throw new IllegalAccessError();
    }

    private WebServer getWebServer(final NeoServer neoServer) {
      if (neoServer instanceof AbstractNeoServer) {
          return ((AbstractNeoServer) neoServer).getWebServer();
      }
      throw new IllegalArgumentException(String.format("Expected: [AbstractNeoServer], Received: [%s].", neoServer));
    }

    private void addFilters() {
        customFilter = new CustomFilter();
        webServer.addFilter(customFilter, "/extension-path/*");
    }

    private void removeFilters() {
        webServer.removeFilter(customFilter, "/extension-path/*");
    }
}