class Foo {
    public static final void go() {}
}

class Bar extends Foo {
    public static void go() {};  // Error
}