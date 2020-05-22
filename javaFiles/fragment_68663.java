private T value = null;
    private Class<T> type;

    public Property(Class<T> type) { this.type = type; }

    public Class<T> getType() { this.type; }