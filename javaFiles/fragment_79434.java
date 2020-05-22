class Foo {
    final String s;
    final int x;

    private void setS(String s) {
        this.s = s;
        this.x = s.length();
    }

    Foo(String s) {
        this.setS(s);
    }
}