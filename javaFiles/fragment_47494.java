public class Worker {

    private static final int CLIENTS_NUMBER = 5;
    private static final BlockingQueue<Client> queue = new LinkedBlockingQueue<>(CLIENTS_NUMBER);

    static {
        for (int i = 0; i < CLIENTS_NUMBER; i++)
            queue.put(new Client());
    }

    @Override
    protected void onGet(Request req) {
        handleRequest(req);
    }

    private void handleRequest(Request req) {
        someRunnableExecutor(new Runnable() {
            @Override
            public void run() {
                try {
                    Client client = takeClient();
                    client.send_req(req);
                    putClient(client);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
    }

    private Client takeClient() throws InterruptedException {
        return queue.take();
    }

    private void putClient(Client client) throws InterruptedException {
        queue.put(client);
    }
}