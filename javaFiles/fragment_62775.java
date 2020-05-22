MyInterface getMyInsterface() {
   ...
   final MyInterface instance = ...

   // Create the proxy and inject the real implementation
   final IMyInterface proxy = (IMyInterface) Proxy.newProxyInstance(
        MyInterfaceProxy.class.getClassLoader(),
        new Class[] {IMyInterface.class},
        new MyInterfaceProxy(instance) // Inject the real instance
    );

   // Return the proxy!
   return proxy;
}