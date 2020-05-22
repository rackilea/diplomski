static class MyHandler implements HttpHandler {

    private final AtomicInteger counter;

    public MyHandler(final AtomicInteger counter) {
        this.counter = counter;
    }

    @Override
    public void handle(final HttpExchange t) throws IOException {
        // ... same code, only reference the counter
    }
}

static class ResetHandler implements HttpHandler {
    private final AtomicInteger counter;

    public ResetHandler(final AtomicInteger counter) {
        this.counter = counter;
    }

    @Override
    public void handle(final HttpExchange exchange) throws IOException {
        counter.set(0);

        exchange.sendResponseHeaders(200, 2);
        exchange.getResponseBody().write("OK".getBytes());
    }
}