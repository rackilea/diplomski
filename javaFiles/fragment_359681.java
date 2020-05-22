Object around(final Object cachedObject) : cacheMethodExecution(cachedObject) {
    MethodSignature methodSignature = (MethodSignature) thisJoinPoint.getSignature();
    Method method = methodSignature.getMethod();

    CacheOperationInvoker aspectJInvoker = new CacheOperationInvoker() {
        public Object invoke() {
            try {
                // Call your method implementation
                return proceed(cachedObject);
            }
            catch (Throwable ex) {
                throw new ThrowableWrapper(ex);
            }
        }
    };

    try {
        // Evict cache, in your case
        return execute(aspectJInvoker, thisJoinPoint.getTarget(), method, thisJoinPoint.getArgs());
    }
    catch (CacheOperationInvoker.ThrowableWrapper th) {
        AnyThrow.throwUnchecked(th.getOriginal());
        return null; // never reached
    }
}