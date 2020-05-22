public void start() {
    startClient(this.vertx);
}

private void startClient(Vertx vertx) {
    HttpClient client = vertx.createHttpClient();

    client.websocket(8080, "localhost", "/", (ctx) -> {
        ctx.textMessageHandler((msg) -> {
            System.out.println("Client " + msg);
            ctx.writeTextMessage("pong");
        }).exceptionHandler((e) -> {
            System.out.println("Restarting in 10 seconds");
            client.close();
            vertx.setTimer(10 * 1000, (__) -> {
                startClient(vertx);
            });
        });
    });
}