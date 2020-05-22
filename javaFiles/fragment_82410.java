public class Test {
    public static void main(String... arg) throws Throwable {
        System.out.println(new Test().foo(100).getAsInt());
    }
    public IntSupplier foo(int capture) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType = MethodType.methodType(int.class, int.class),
            functionType = MethodType.methodType(int.class),
            invokedType = MethodType.methodType(IntSupplier.class, Test.class, int.class);
        MethodHandle methodHandle=lookup.findVirtual(getClass(),"addFortyTwo",methodType);
        CallSite callSite = LambdaMetafactory.metafactory(lookup, "getAsInt",
            invokedType, functionType, methodHandle, functionType);
        return (IntSupplier) callSite.getTarget().invokeExact(this, capture);
    }
    public int addFortyTwo(int valueToAdd) {
        return 42+valueToAdd;
    }
}