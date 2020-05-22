public static void main(String[] args) {
    Foo foo = Foo.newFoo();
    foo.setEnabled(false);
    foo.bar(); // won't print anything.
    foo.setEnabled(true);
    foo.bar(); // prints "Executing method bar"
}