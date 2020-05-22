HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
server.createContext("/a", new MyHandler("A"));
server.createContext("/b", new MyHandler("B"));

public static class MyHandler implements HttpHandler {

    private String identity;

    public MyHandler(String identity) {
        this.identity = identity;
    }

    @Override
    public void handle(HttpExchange t) throws IOException { // How use if here?
        String response = "I am " + identity + " response";
        t.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}