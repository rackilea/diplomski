interface InterfaceA
{
    void method();
}

interface InterfaceB
{
    void method();
}

public class InheritsFromTwoInterfaces
    implements InterfaceA, InterfaceB
{
    void method() { System.out.println("method()"); }
}