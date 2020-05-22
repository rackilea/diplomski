MethodHandles.Lookup l = MethodHandles.privateLookupIn(Class.class, MethodHandles.lookup());
MethodHandle target = l.findSpecial(Class.class, "getDeclaredFields0",
    MethodType.methodType(Field[].class, boolean.class), Class.class);
BiFunction<Class<?>,Boolean,Field[]> a = (BiFunction)LambdaMetafactory.metafactory(
    l, "apply", MethodType.methodType(BiFunction.class), target.type().generic(),
    target, target.type().changeParameterType(1, Boolean.class))
    .getTarget().invokeExact();