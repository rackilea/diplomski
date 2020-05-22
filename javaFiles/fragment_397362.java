public static void main(String[] args) throws NoSuchMethodException {

    final Method opNumber = ITest.class.getMethod("op", Number.class);
    final Method opDouble = ITestDouble.class.getMethod("op", Double.class);
    final Method other = ITestDouble.class.getMethod("other");

    ITestDouble dynamic = (ITestDouble) Proxy.newProxyInstance(
            ITestDouble.class.getClassLoader(),
            new Class<?>[]{ITestDouble.class},
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
                    if (opDouble.equals(m)) return 1;
                    if (opNumber.equals(m)) return 2;
                    // etc....

                    return null;
                }
            });

    System.out.println("op(Double): " + dynamic.op(null);            // prints 1.
    System.out.println("op(Number): " + ((ITest) dynamic).op(null);  // prints 2. Compiler gives warning for raw types
}