} catch (InvocationTargetException e) {
    if (e.getCause() instanceof RuntimeException) {
        throw (RuntimeException) e.getCause();
    }
    if (e.getCause() instanceof Error) {
        throw (Error) e.getCause();
    }
    throw new InternalException("Method invocation with reflection failed.", e);
}