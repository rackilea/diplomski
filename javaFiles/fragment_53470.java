interface Counter {
    static Counter createDefault() {
        return new ConcreteCounter();
    }

    void add(int i);
    default void increment() {
       this.add(1);
    }
}