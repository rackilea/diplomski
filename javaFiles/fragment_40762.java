public class Foo {

    private String foo;

    public void setFoo(String foo) {
        System.out.println(foo);
        this.foo = foo;
    }

    @Override
    public String toString() {
        return "Foo [foo=" + this.foo + "]";
    }

}