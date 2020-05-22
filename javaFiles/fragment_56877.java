public abstract class A {
     public abstract int x();
}

public class B extends A {
    int x = 5;

    @Override
    public int x() {
        return x + 2;
    }
..
}