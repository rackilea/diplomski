interface Counter {
    void add(int i);
    default void increment() {
       this.add(1);
    }
}