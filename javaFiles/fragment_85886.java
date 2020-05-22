class ListId<T> {
    public ListId(string name) { ... }

    public static final ListId<ArrayList<String>> A = new ListId<>("a");
    public static final ListId<LinkedList<Integer>> B = new ListId<>("b");
}

public T getList<T>(ListId<T> id)