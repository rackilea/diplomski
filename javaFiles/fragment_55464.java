public static void main(String[] args) throws InterruptedException {

        Queue<SseClient> clients = new ConcurrentLinkedQueue<>();

        Javalin app = Javalin.create().start(7000);
                app.sse("/sse", client -> {
            clients.add(client);
            client.onClose(() -> clients.remove(client));
        });

        while (true) {
            for (SseClient client : clients) {
                client.sendEvent("hi", "hello world");
            }
            TimeUnit.SECONDS.sleep(1);
        }

    }