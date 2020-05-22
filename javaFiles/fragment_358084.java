public class SCD_Checker {
    private final ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private Connection conn = new Connection();

    SCD_Checker() {
        conn.setProvider("ADsDSOObject");
        conn.Open("Active Directory Provider", "", "", 0);
    }

    public Future<WorkerDTO> submit_task(String email) {
        return this.service.submit(new CheckStatusCallable(conn, email));
    }

    public void shutdown_and_close() throws InterruptedException {
        this.service.shutdown();
        this.service.awaitTermination(1, TimeUnit.MINUTES);
        this.conn.Close();
    }
}