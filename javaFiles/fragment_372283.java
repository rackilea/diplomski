public static void main(String[] args) throws Exception {
    Server server = new Server();
    server.setHandler(new DefaultHandler()); // 404s for everything except favicon.ico

    HttpConfiguration config = new HttpConfiguration();
    config.setRequestHeaderSize(65535);
    ServerConnector http = new ServerConnector(server, new HttpConnectionFactory(config));
    http.setPort(8080);
    server.setConnectors(new Connector[] {http});

    server.start();
    server.join();
}