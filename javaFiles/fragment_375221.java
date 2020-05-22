interface InterfaceA
{
     void interfaceMethodA();
}

interface InterfaceB
{
    void interfaceMethodB();
}

public class ImplementingClassA
    implements InterfaceA, InterfaceB
{
    public void interfaceMethodA()
    {
        System.out.println("interfaceA, interfaceMethodA, implementation A");
    }

    public void interfaceMethodB()
    {
        System.out.println("interfaceB, interfaceMethodB, implementation A");
    }
}

public class ImplementingClassB
    implements InterfaceA, InterfaceB
{
    public void interfaceMethodA()
    {
         System.out.println("interfaceA, interfaceMethodA, implementation B");
    }

    public void interfaceMethodB()
    {
        System.out.println("interfaceB, interfaceMethodB, implementation B");
    }
}