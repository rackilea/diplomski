public class ErrorHandler extends DefaultHttpErrorHandler {

    private ErrorController errorController;

    @Inject
    public ErrorHandler(Configuration configuration,
                        Environment environment,
                        OptionalSourceMapper sourceMapper,
                        Provider<Router> routes,
                        ErrorController errorController) {
        super(configuration, environment, sourceMapper, routes);

        this.errorController = errorController;
    }

    @Override
    public CompletionStage<Result> onServerError(Http.RequestHeader request, Throwable exception) {
        Logger.debug("Error: onServerError general");
        return CompletableFuture.completedFuture(this.errorController.serverErrorPage());
    }

    @Override
    protected CompletionStage<Result> onBadRequest(Http.RequestHeader request, String message) {
        Logger.debug("Error: onBadRequest, message: " + message);
        return CompletableFuture.completedFuture(this.errorController.badRequestPage());
    }

    @Override
    protected CompletionStage<Result> onForbidden(Http.RequestHeader request, String message) {
        Logger.debug("Error: onForbidden, message: " + message);
        return CompletableFuture.completedFuture(this.errorController.forbiddenPage());
    }

    @Override
    protected CompletionStage<Result> onNotFound(Http.RequestHeader request, String message) {
        Logger.debug("Error: onNotFound, message: " + message);
        return CompletableFuture.completedFuture(this.errorController.notFoundPage());
    }

    @Override
    protected CompletionStage<Result> onOtherClientError(Http.RequestHeader request, int statusCode, String message) {
        Logger.debug("Error: onOtherClientError, message: " + message);
        return CompletableFuture.completedFuture(this.errorController.errorDefaultPage());
    }
}