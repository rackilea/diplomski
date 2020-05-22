public class Foo {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Foo foo1 = null;
        Foo foo2 = new Foo();
        Foo foo3 = new Foo();
        foo3.setName("foo3");
        Foo foo4 = new Foo();
        foo4.setName("foo4");
        List<Foo> fooList = Arrays.asList(foo1, foo2, foo3, foo4);
        Optional<String> found = findFirstNonNull(fooList, Foo::getName);
        System.out.println(found); // Optional[foo3]
    }
}