public void handleException(Throwable exception, SubscriberExceptionContext context) {
    // Check if the exception is of some type you wish to be rethrown, and rethrow it.
    // Here I'll assume you'd like to rethrow RuntimeExceptions instead of 'consuming' them.
    if (exception instanceof RuntimeException) {
        throw (RuntimeException) exception;
    }

    // If the exception is OK to be handled here, do some stuff with it, e.g. log it.
    ...
}