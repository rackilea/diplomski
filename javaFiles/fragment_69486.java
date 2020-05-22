public class InternalServerExceptionClassifierRetryPolicy extends ExceptionClassifierRetryPolicy {

    public InternalServerExceptionClassifierRetryPolicy() {

        final SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
        simpleRetryPolicy.setMaxAttempts(3);

        this.setExceptionClassifier(new Classifier<Throwable, RetryPolicy>() {
            @Override
            public RetryPolicy classify(Throwable classifiable) {
                if (classifiable instanceof HttpServerErrorException) {
                    // For specifically 500 and 504
                    if (((HttpServerErrorException) classifiable).getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR
                            || ((HttpServerErrorException) classifiable)
                                    .getStatusCode() == HttpStatus.GATEWAY_TIMEOUT) {
                        return simpleRetryPolicy;
                    }
                    return new NeverRetryPolicy();
                }
                return new NeverRetryPolicy();
            }
        });
    }
}