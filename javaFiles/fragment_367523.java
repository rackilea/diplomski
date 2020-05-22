package net.bounceme.dur.misc;

public class StaticRef {

    private Foo f = Foo.INSTANCE;

    public StaticRef() throws Exception {
        f.connect();
    }

    public static void main(String[] args) throws Exception {
        new StaticRef();
    }
}