static class MyHandler implements HttpHandler {
    static int counter = 0;
    @Override
    public void handle(HttpExchange t) throws IOException {
        String response = String.format("This is response %d%n", counter++);
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}