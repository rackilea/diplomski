public class Main {

    static {
        System.loadLibrary("YOUR_LIBRARY_NAME_HERE");
    }

    public static void main(String[] args) {
        Foo foo = Bar.createFoo("(ILjava/lang/String;)V", -12312141, "foo");

        System.out.println(foo);

        foo.method1();

        foo = Bar.createFoo("(I)V", -12312141, "foo");

        System.out.println(foo);

        foo.method1();

        foo = Bar.createFoo("(I)V", -12312141);

        System.out.println(foo);

        foo.method1();
    }
}