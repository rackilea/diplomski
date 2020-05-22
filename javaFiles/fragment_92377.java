new IntConsumer() {
    @Override
    public void accept(int y) {
        value1.incrementAndGet();
    }
});