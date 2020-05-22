public static void main(String[] args) throws Exception {
    Server server = new Server(8080);
    server.setHandler(new DefaultHandler()); // 404s for everything except favicon.ico

    for (Connector c : server.getConnectors()) {
        c.getConnectionFactory(HttpConnectionFactory.class).getHttpConfiguration().setRequestHeaderSize(65535);
    }

    server.start();
    server.join();
}