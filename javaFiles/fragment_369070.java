public abstract class Foo {
    public abstract Number getThing();
}

public class Bar extends Foo {
    @Override
    public Integer getThing() {
        //copying;
    }
}