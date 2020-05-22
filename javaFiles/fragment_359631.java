public static <T> List<T> emptyList() {
    return THEEMPTYLIST;
}

public static final List THEEMPTYLIST = new List() {
    public int size() { return 0; }
    ...
};