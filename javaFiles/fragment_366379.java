public class Foo {
    @JsonView(Views.Public.class)
    public String bar;
    @JsonView(Views.Internal.class)
    public String biz;
}

public class FooContainer {
    public Foo fooA;
    @FilterUsingView(Views.Public.class)
    public Foo fooB;
}