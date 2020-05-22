public class Bar {

    private final Map<Integer, Foo> map;

    public Bar() {
        map = new HashMap<>();

        map.put(0, new Foo(0));
        map.put(5, new Foo(5));
        map.put(6, new Foo(6));
    }

    private void list() {
        System.out.println(map.get(0).toString());
        System.out.println(map.get(5).toString());
        System.out.println(map.get(6).toString());
    }

    public static void main(String[] args) {
        Bar bar = new Bar();
        bar.list();
    }
}