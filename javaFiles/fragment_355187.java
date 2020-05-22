class Counter {
    static int nextId = 0;
    static int nextId() { return nextId++; }

    final int id = nextId();
    final String name;

    public Counter() {
        this("Unnamed counter");
    }
    public Counter(String name) {
        this.name = name;
    }

}