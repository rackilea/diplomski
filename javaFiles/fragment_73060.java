public enum Ids {
    OPEN(100), CLOSE(200);

    private final int id;
    Ids(int id) { this.id = id; }
    public int getValue() { return id; }
}