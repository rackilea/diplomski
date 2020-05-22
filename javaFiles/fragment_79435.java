class Foo {
    final String s;

    private int getX() {
        return s.length();
    }

    Foo(String s) {
        this.setS(s);
    }
}