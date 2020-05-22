class Counter {
    // The StringProperty to whom the Text node's textProperty will be bound to
    private StringProperty counter; 

    public Counter() {
        counter = new SimpleStringProperty();
    }

    public Counter(int count) {
        this();
        counter.set(Integer.toString(count));
    }

    public void set(int count) {
        counter.set(Integer.toString(count));
    }
}