@Override
public void start() {
    vertx.<Void>executeBlocking(f -> {
        while (true) {
            // blocking...
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            vertx.eventBus().publish("channel.1", "msg");
        }
    }, voidAsyncResult -> System.out.println("done"));
}