interface Foo {
    void m() throws Exception;
}

interface Bar extends Foo {
    @Override
    void m();
}

void test(Foo foo, Bar bar) {
    foo.m(); // must catch exception
    bar.m(); // no exception declared to be thrown, so don't need to catch
}