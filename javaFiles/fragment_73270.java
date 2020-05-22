// given...

@JsonDeserialize(using=MyDeserializer.class)
class Foo {
    String foo;
    public void setFoo(String s) {
        foo = s;
    }
    public String getFoo() {
        return foo;
    }
    public Foo(String s) {
        setFoo(s);
    }
}