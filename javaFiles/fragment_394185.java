private class MyCallable implements Callable {

    @TimerJoin
    public MyCallable() {
    }

    @Override
    public Object call() throws Exception {
        someOtherMethod();
        return null;
    }

    @TimerEnd
    private void someOtherMethod() throws InterruptedException {
        Thread.sleep(1000);
    }
}