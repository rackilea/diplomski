return requestScope.runInScope(new Producer<T>() {
    @Override
    public T call() throws ProcessingException {
        try {
            return translate(runtime.invoke(requestForCall(requestContext)), requestScope, responseType);
        } catch (final ProcessingException ex) {
            if (ex.getCause() instanceof WebApplicationException) {
                throw (WebApplicationException) ex.getCause();
            }
            throw ex;
        }
    }
});