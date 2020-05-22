public static MyFactory getRuntimeClass(Class<? extends MyClass> cls) {
    try {
        MethodHandles.Lookup l = MethodHandles.lookup();
        MethodHandle c = l.findConstructor(cls,
                             MethodType.methodType(void.class, String.class));
        MethodType ft = c.type().changeReturnType(MyClass.class);
        return (MyFactory)LambdaMetafactory.metafactory(l, "getInstance",
            MethodType.methodType(MyFactory.class), ft, c, ft).getTarget().invokeExact();
    }
    catch(RuntimeException | Error t) {
        throw t;
    }
    catch(Throwable t) {
        throw new IllegalArgumentException(t);
    }
}