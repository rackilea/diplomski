Class<?> homeHandlerClass = HomeHandler.class;

Method method = homeHandlerClass.getDeclaredMethod(
        "handle", RoutingContext.class);
Lookup lookup = MethodHandles.lookup();
MethodHandle mh = lookup.unreflect(method);

MethodType factoryMethodType = MethodType.methodType(Handler.class, HomeHandler.class);
MethodType functionMethodType = MethodType.methodType(void.class, Object.class);
MethodHandle implementationMethodHandle = mh;

Handler<RoutingContext> lambda =
        (Handler<RoutingContext>) LambdaMetafactory.metafactory(
                lookup,
                "handle",
                factoryMethodType, 
                functionMethodType,
                implementationMethodHandle,
                implementationMethodHandle.type().dropParameterTypes(0, 1)) 
        .getTarget()
        .invokeExact(new HomeHandler()); // capturing instance
lambda.handle(ctx);