public abstract class AbstractSlave {

    private final Worker worker;

    public AbstractSlave(Worker worker) {
        this.worker = worker;
    }

    final void handle(final Request request, final Response response)
        // Some operations before starting worker thread.

        Thread t = new Thread() {
            public void run() {
                worker.work(request, response);
            }
        };
        t.start();
    }

}