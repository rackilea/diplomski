abstract public class AbstractClassA
{
    void method() { System.out.println("Hello"); }
}

abstract public class AbstractClassB
{
    void method() { System.out.println("Goodbye"); }
}

public class InheritsFromTwoAbstractClasses
    extends AbstractClassA, AbstractClassB
{ }