class MyClass {
    public static void main(String[] args) {
        ExecutorService service = Executors.newScheduledThreadPool(10);
        DoubleStream.of(3.14159, 2.71828)
            .forEach(new DoubleConsumer() {
            @Override public void accept(double value) {
                lambda1(service, value);
            }
        });
    }
    private static void lambda1(ExecutorService service, double c) {
        service.submit(new Runnable() {
            @Override public void run() {
                lambda2(c);
            }
        });
    }
    private static void lambda2(double c) {
        System.out.println(c);
    }
}