abstract public class AbstractClassA
{
    void hi() { System.out.println("Hello"); }
}

abstract public class AbstractClassB
{
    void bye() { System.out.println("Goodbye"); }
}

public class InheritsFromTwoAbstractClasses
    extends AbstractClassA, AbstractClassB
{ }