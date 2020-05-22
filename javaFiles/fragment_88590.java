int computeSum(Server server) throws InterruptedException {
    // Any InterruptedException thrown below is propagated
    int a = server.getValueA();
    int b = server.getValueB();
    return a + b;
}