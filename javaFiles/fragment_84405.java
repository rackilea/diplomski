public class MyClass {

    private final SomeType one;
    private final SuperType two;

    public MyClass (SomeType commonArg, int intIn) {
        this(commonArg, new SubTypeOne(intIn));
    }

    public MyClass (SomeType commonArg, String stringIn) {
        this(commonArg, new SubTypeTwo(stringIn));
    }

    private MyClass (SomeType commonArg, SuperType twoIn) {
        one = commonArg;
        two = twoIn;
    }
}