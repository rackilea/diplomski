public class SomeClass {

    ....

    class SubInnerClass extends InnerClass {
        public final void execute() {
            incrementValue();
        }
    }

    public final InnerClass called = new SubInnerClass(this);

    ....
}