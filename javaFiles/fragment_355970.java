public class Sub1 extends SuperClass {
    private SomeType fieldSub1;

    public Sub1(SomeType fieldSub1) {
        super(generateId(fieldSub1));
        this.fieldSub1 = fieldSub1;
    }

    private static String generateId(SomeType fieldSub1) {
        // Some operations that use fieldSub1
    }
}