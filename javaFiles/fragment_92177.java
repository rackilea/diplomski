class SomeElement  {

    private final DefaultHttpErrorHandler errorHandler;

    @Inject
    public SomeElement(DefaultHttpErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }

    public CompletionStage<Result> onAuthFailure(final Http.Context context,
                                                 final Optional<String> content) {
        return this.errorHandler.onClientError(context.request(), Http.Status.FORBIDDEN, "You don't have required permissions.");
    }
}