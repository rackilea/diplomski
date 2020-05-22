public class Foo {}
public class Bar {
    public Bar(Foo foo){}
}
public class SubBar extends Bar {
    public SubBar(Foo foo) {
        super(foo);
    }
}