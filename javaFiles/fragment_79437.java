class Foo {
    final String s;
    final int x;

    Foo(String s) {
        this.s = s;
        this.x = this.s.length();
    }
}