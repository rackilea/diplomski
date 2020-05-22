class ConcreteCounter implements Counter {
    private int value = 0;

    @Override 
    public void add(int i) {
        this.value += i;
    }
}