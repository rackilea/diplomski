class RealProxy extends Real {
    private ExecutorService executorService; // potentiall configured in Async configuration
    private Real target; // the actual object
    @Override
    public void method() {
        executorService.submit(() -> target.method());
    }
}