@Override
public boolean preHandle(
        final HttpServletRequest request,
        final HttpServletResponse response,
        final Object handler
) throws Exception {
    if (handler instanceof HandlerMethod) {
        if (shouldCheckInit((HandlerMethod) handler)) {
            checkInit();
        }
    }

    return true;
}

private static boolean shouldCheckInit(final HandlerMethod handlerMethod) {
    final var typeAnnotation = handlerMethod.getBeanType().getAnnotation(CheckInit.class);
    final var shouldCheckInit = typeAnnotation != null && typeAnnotation.value();

    final var methodAnnotation = handlerMethod.getMethodAnnotation(CheckInit.class);
    return (methodAnnotation == null || methodAnnotation.value()) && shouldCheckInit;
}

private void checkInit() throws Exception {
    if (!manager.isActive()) {
        throw new NotInitializedException();
    }
}