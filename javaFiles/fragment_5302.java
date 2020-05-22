@Around(...)
public Object serviceLayerTraceAdviceBasedElementInstanceAfter2(final ProceedingJoinPoint pjp,
                    final ElementNiveauUn element, final Traceable traceable) throws SecurityException,
                    NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    ...
    Object result = pjp.proceed();
    ...
    return result;
}