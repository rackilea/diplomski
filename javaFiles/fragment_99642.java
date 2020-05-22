try {
    return paymentFuture.get();
} catch (InterruptedException | ExecutionException exception) {
    final Throwable cause = exception.getCause();
    if (cause instanceof PaymentException) {
       throw (PaymentException) cause;
    }
    throw new ProcessorException("task interrupted or failed", exception);
}