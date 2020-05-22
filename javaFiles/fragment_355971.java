public abstract class SuperClass {
    private String id;

    public String getId() {
        if (id == null) { id = generateId(); }
        return id;
    }
    protected abstract String generateId();
}


public class Sub1 extends SuperClass {
    private SomeType fieldSub1;

    public Sub1(SomeType fieldSub1) {
        this.fieldSub1 = fieldSub1;
    }

    @Override protected String generateId() {
        // Some operations that use fieldSub1
    }
}