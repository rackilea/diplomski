BI_CONSUMER(new BiConsumer<Integer, String>() {
    @Override
    public void accept(Integer i, String s) {
        printString(); // has a return value, but is it used?
    }
});