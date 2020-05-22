public class Foo {

    private final String bar = "hello";


    static class SubFoo extends Foo {
        private final String bar = "world";
    }

    public <T extends SubFoo> void printFoo(T baz) {
//      System.out.println(baz.bar); // doesn't compile
        System.out.println(((Foo)baz).bar); //hello
        System.out.println(((SubFoo)baz).bar); //world
    }

    public static void main(String[] args) {
        new Foo().printFoo(new SubFoo()); //prints "hello\nworld"
    }
}