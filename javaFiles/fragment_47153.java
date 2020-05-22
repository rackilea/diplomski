public class ChildClass extends ParentClass {
    @Override
    public void myMethod(final double value) {
        new Runnable() {
            @Override
            public void run() {
                ChildClass.super.myMethod(value);
            }
        };
    }
}