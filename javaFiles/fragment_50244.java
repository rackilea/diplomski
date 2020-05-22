final ThreadLocal<Object[]> localContext;

/** Looks up thread local context. Creates (and removes) a new context if necessary. */
<T> T callInContext(ContextualCallable<T> callable) throws ErrorsException {
    Object[] reference = localContext.get();
    if (reference[0] == null) {
        reference[0] = new InternalContext();
        try {
            return callable.call((InternalContext)reference[0]);
        } finally {
            // Only clear the context if this call created it.
            reference[0] = null;
        }
    } else {
        // Someone else will clean up this context.
        return callable.call((InternalContext)reference[0]);
    }
}