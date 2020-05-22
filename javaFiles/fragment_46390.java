public class Foo {

    private final String bar = "bar";

    public void printFoo(SubFoo baz) {
        System.out.println(baz.bar); //bar is not visible
    }
}

class SubFoo extends Foo {      
}