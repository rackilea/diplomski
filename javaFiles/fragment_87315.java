abstract class BaseClass {
    protected final int a;

    protected BaseClass(int a)
    {
        this.a = a;
    }
}

class SubClass extends BaseClass {
    public SubClass() {
        super(6);
    }
}