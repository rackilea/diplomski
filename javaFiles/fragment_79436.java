class Foo {
    final String s;
    private int cached_x = null;

    int getX() {
        if (x == null) {
            cached_x = s.lenth();
        return cached_x;
    }

    Foo(String s) {
        this.s = s;
    }
}