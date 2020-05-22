class Outer {

    int foo = 0;
    int bar = 5;

    private final InnerFactory innerFactory = new InnerFactory();

    List<Inner> test() {
        Inner fromFoo = innerFactory.newFromFoo();
        Inner fromBar = innerFactory.newFromBar();

        return Arrays.asList(fromFoo, fromBar);
    }

    private class InnerFactory {

        Inner newFromFoo() {
            // I'm an inner class, so I can access member variables 
            // of enclosing Outer
            return new Inner(foo);   
        }

        Inner newFromBar() {
            return new Inner(bar);
        }
    }

    public class Inner {

        int baz;

        Inner(int baz) {
            this.baz = baz;
        }
    }

}