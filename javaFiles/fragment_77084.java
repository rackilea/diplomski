class Record {
    private final String value1;
    private final String value2;

    public boolean value1_Equals(Record other) {
        return this.value1.equals(other.value1);
    }

    public void printTo(OutputStream out) {
        ...
    }
}