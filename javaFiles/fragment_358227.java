public class Foo {
    // Note that good code almost never has public fields; this is for demo purposes only
    public Bar bar;
}

public class Bar {
    @Override public String toString() {
        return "Message";
    }
}