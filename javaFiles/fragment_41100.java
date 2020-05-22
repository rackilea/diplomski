@Bean
public TcpConnectionFactoryFactoryBean factory(LengthHeaderDeserializer deserializer) throws Exception {
    CompletableFuture.runAsync(() -> waitForSocket(port)).get(5, TimeUnit.MINUTES);

    TcpConnectionFactoryFactoryBean fact = new TcpConnectionFactoryFactoryBean();
    ....
}

private void waitForSocket(int port) {
    do {
        try {
            SocketUtils.findAvailableTcpPort(port, port);
            return;
        } catch (Exception e) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e1) {
                return;
            }
        }
    } while (true);
}