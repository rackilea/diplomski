public class LinkWithDynamicDispatch {
    static final MethodHandle DISPATCHER;
    static {
        try {
            DISPATCHER = MethodHandles.lookup().findStatic(LinkWithDynamicDispatch.class, "simpleDispatcher",
                MethodType.methodType(MethodHandle.class, MethodHandle.class, String.class, Object.class));
        } catch(NoSuchMethodException|IllegalAccessException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static CallSite bootstrap(MethodHandles.Lookup l, String name, MethodType type){
        MethodHandle target;
        try {
            target = l.findVirtual(type.parameterType(0), name, type.dropParameterTypes(0, 1));
        } catch(NoSuchMethodException|IllegalAccessException ex) {
            throw new BootstrapMethodError(ex);
        }
        MethodHandle d = MethodHandles.insertArguments(DISPATCHER, 0, target, name);
        target = MethodHandles.foldArguments(MethodHandles.exactInvoker(type),
            d.asType(d.type().changeParameterType(0, type.parameterType(0))));
        return new ConstantCallSite(target);
    }
    public static MethodHandle simpleDispatcher(
            MethodHandle invokeVirtualTarget, String methodName, Object rec) {
        System.out.println("simpleDispatcher(): invoke "+methodName+" on "
            + "declared receiver type "+invokeVirtualTarget.type().parameterType(0)+", "
            + "actual receiver "+(rec==null? "null": "("+rec.getClass().getName()+"): "+rec));
        return invokeVirtualTarget;
    }
}