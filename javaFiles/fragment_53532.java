class RuntimeClass implements Runnable {
    public void run() {
        TestLambda testLambda = new TestLambda();
    }
}

synchronized(new RuntimeClass()) {
}