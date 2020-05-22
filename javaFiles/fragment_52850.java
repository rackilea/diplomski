public class BB extends AA {

    @Override   // it doesn't compile - no overriding here
    public void foo() { ... }
    @Override   // it does override
    public void goo() { ... }

}