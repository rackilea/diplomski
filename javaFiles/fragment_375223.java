public void testInterfaces()
{
    InterfaceA y = new ImplementingClassA();
    InterfaceB z = new ImplementingClassB();

    y.interfaceMethodB(); // ERROR!
    z.interfaceMethodA(); // ERROR!
}