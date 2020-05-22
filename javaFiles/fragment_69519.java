public class Foo {
    public static void main(String [] args) {
        Foo foo = new Foo();
        foo.bar();  // Associated with the new Foo instance named foo.
    }

    public void bar() {
        System.out.println("compiler won't complain");
    }
}