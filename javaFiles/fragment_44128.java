class FooManager {
    private static HashMap<Integer, Foo> foos = new HashMap<>();

    static {
        for(Foo foo : Foo.values()) {
            foos.put(foo.getId(), foo);
        }
    }

    public static Foo getFoo(int id) {
        return foos.get(id);
    }

    //enum Foo goes here
}