public void startService() {

try {
    ExecutorService service = Executors.newFixedThreadPool(3);


        service.submit(new Service1(conn)); // assuming callable impl is moved

        service.submit(new Service2(conn));

        // like above i have 15 services. so its ugly.
    service.shutdown();

} catch (InterruptedException e) {
    e.printStackTrace();
}
}