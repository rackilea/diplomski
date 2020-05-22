public static <N extends Number> StringFunction<N> create(Class<N> type) throws Throwable {
    MethodType methodType = MethodType.methodType(type, String.class);
    MethodHandles.Lookup lookup = MethodHandles.lookup();
    MethodHandle handle = lookup.findConstructor(type, 
      MethodType.methodType(void.class, String.class));
    StringFunction<N> f = (StringFunction<N>) LambdaMetafactory.metafactory(lookup, "apply", 
      MethodType.methodType(StringFunction.class), 
      methodType.changeReturnType(Number.class), handle, methodType).getTarget().invokeExact();
    return f;
}