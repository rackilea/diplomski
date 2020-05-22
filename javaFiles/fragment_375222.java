public void testInterfaces()
{
    ImplementingClassA u = new ImplementingClassA();
    ImplementingClassB v = new ImplementingClassB();
    InterfaceA w = new ImplementingClassA();
    InterfaceA x = new ImplementingClassB();
    InterfaceB y = new ImplementingClassA();
    InterfaceB z = new ImplementingClassB();

    u.interfaceMethodA();
    // prints "interfaceA, interfaceMethodA, implementation A"
    u.interfaceMethodB();
    // prints "interfaceB, interfaceMethodB, implementation A"
    v.interfaceMethodA();
    // prints "interfaceA, interfaceMethodA, implementation B"
    v.interfaceMethodB();
    // prints "interfaceB, interfaceMethodB, implementation B"
    w.interfaceMethodA();
    // prints "interfaceA, interfaceMethodA, implementation A"
    x.interfaceMethodA();
    // prints "interfaceA, interfaceMethodA, implementation B"
    y.interfaceMethodB();
    // prints "interfaceB, interfaceMethodB, implementation A"
    z.interfaceMethodB();
    // prints "interfaceB, interfaceMethodB, implementation B"
}