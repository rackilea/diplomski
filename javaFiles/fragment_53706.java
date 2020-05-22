public abstract class TestClass
{
    private final int data;

    protected TestClass(int data) { this.data = data; }

    public final class InnerClass extends TestClass
    {
        private InnerClass(int data) { super(data); }        
    }
    public static final TestClass CONSTANT = ((TestClass) null).new InnerClass(5);
}