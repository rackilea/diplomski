MethodHandle theHandle = ...
Object theInstance = ...
MethodHandle adapted = theHandle.bindTo(theInstance);
Handler<RoutingContext> lambda = ctxt -> {
    try {
        adapted.invokeExact(ctxt);
    } catch (Throwable e) {
        throw new RuntimeException(e);
    }
};
lambda.handle(new RoutingContext());