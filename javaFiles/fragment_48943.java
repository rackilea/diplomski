MyClass mc = new MyClass();
Object proxy = Proxy.newProxyInstance(null, new Class<?>[] { InterfaceA.class, InterfaceB.class }, new MyClassInvocationHandler(mc));
InterfaceA a = (InterfaceA) proxy;
a.doSomething();
InterfaceB b = (InterfaceB) proxy;
b.doSomething();