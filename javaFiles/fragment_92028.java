// the signature of the method returned by LambdaMetaFactory
// it takes an object of bean's type and makes a MapHandler that calls one
// of its instance methods
MethodType mkLambdaType = MethodType.methodType(MapHandler.class, bean.getClass());
// the signature of the method in MapHandler being implemented
MethodType handleType = MethodType.methodType(Mono.class, Mono.class);
MethodHandles.Lookup lookup = MethodHandles.lookup();

// FYI this won't search in supertypes
// getMethods() will, but you only get public ones even if you have more privileged access
// you decide what to do here; the loop body is the important thing
for(Method method : bean.getClass().getDeclaredMethods()) {
    if(Modifier.isStatic(method.getModifiers())) continue;
    try {
        MethodHandle target = lookup.unreflect(method);
        CallSite mkLambda = LambdaMetafactory.metafactory
            (lookup, "handle", mkLambdaType, handleType, target, handleType);
        list.add((MapHandler)mkLambda.getTarget().invoke(bean));
    } catch(IllegalAccessException | LambdaConversionException e) {
        // because I am lazy, I'm not checking that method has the correct type
        // I'm letting LambdaMetafactory throw if that's not the case
        // if you choose not to use LambdaMetafactory, you may have to implement
        // this type-checking
        continue;
    } catch(Throwable t) {
        // Throwables come from the MethodHandle#invoke call
        // but nothing should be thrown at all, because LambdaMetafactory
        // produces its errors from metafactory, early, which are caught above
        throw new RuntimeException("Unexpected error during reflection", t);
    }
}