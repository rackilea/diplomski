package de.scrum_master.app;

public class Application {
    @Authorized static void bla(String string, int i, int j) {}
    @Authorized static void baz(String string, int i, Integer integer) {}
    @Authorized static void zot(String string) {}
    @Authorized static void bar(Integer integer) {}
    @Authorized static void foo() {}

    public static void main(String[] args) {
        foo();
        bar(new Integer(11));
        zot("xxx");
        baz("yyy", 123, new Integer(22));
        bla("zzz", 123, 456);
    }
}