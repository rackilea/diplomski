class ID {
    private static volatile long id = 0;
    public synchronized long nextId() {
        return id++;
    }
}