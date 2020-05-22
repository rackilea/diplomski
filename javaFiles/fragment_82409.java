public class Test {
    public static void main(String... arg) throws Throwable {
        System.out.println(new Test().foo().getAsInt());
    }
    public IntSupplier foo() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType methodType  = MethodType.methodType(int.class),
                   invokedType = MethodType.methodType(IntSupplier.class, Test.class);
        MethodHandle methodHandle = lookup.findVirtual(getClass(), "fortyTwo", methodType);
        CallSite callSite = LambdaMetafactory.metafactory(lookup, "getAsInt",
            invokedType, methodType, methodHandle, methodType);
        return (IntSupplier) callSite.getTarget().invokeExact(this);
    }
    public int fortyTwo() {
        return 42;
    }
}