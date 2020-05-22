interface Interface
{
    void abstractMethod();
}

abstract public class AbstractClass
    implements Interface
{
    abstract public void abstractMethod();
}

public class InheritsFromInterfaceAndAbstractClass
    extends AbstractClass implements Interface
{
    public void abstractMethod() { System.out.println("abstractMethod()"); }
}