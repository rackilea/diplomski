public class Outer {
    public class Inner{
        // notice the lack of static keyword
    }
}

public class ExtendedOuter extends Outer {

    private static Outer outer = new ExtendedOuter(); // or any other instance

    public static class ExtendedInner extends Inner {
        public ExtendedInner() {
            outer.super(); // this call is explicitly required
        }
    }

}