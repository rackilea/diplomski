@Override
public void handle(final HttpExchange t) throws IOException {
    final String response;

    final String requestMethod = t.getRequestMethod();
    if ("GET".equals(requestMethod)) {
        response = String.format("Besuche: %d%n", atomicInteger.addAndGet(1));
    }
    else if ("POST".equals(requestMethod)) {
        atomicInteger.set(0);

        response = "Reset to 0";
    }
    else {
        throw new IOException("Unsupported method");
    }

    t.sendResponseHeaders(200, response.length());
    final OutputStream os = t.getResponseBody();
    os.write(response.getBytes());
    os.close();
}