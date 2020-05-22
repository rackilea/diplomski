public class MyDeadboltHandler implements DeadboltHandler {
    private final DeadboltExecutionContextProvider executionContextProvider;
    private final DeadboltAnalyzer analyzer;

    @Inject
    public MyDeadboltHandler(final ExecutionContextProvider ecProvider,
                             final DeadboltAnalyzer analyzer) {
        this.executionContextProvider = ecProvider.get();
        this.analyzer =analyzer;
    }

    public CompletionStage<Result> onAuthFailure(Http.Context context,
                                                 Optional<String> content) {
        final ExecutionContext executionContext = executionContextProvider.get();
        final ExecutionContextExecutor executor = HttpExecution.fromThread(executionContext);
        return getSubject(context).thenApplyAsync(maybeSubject ->
            maybeSubject.map(subject -> analyzer.hasRole(maybeSubject, "admin") ? /*go to admin section*/
                                                                                : /*go to non-admin section*/)
                        .orElseGet(() -> /*no user present*/),
                                   executor);
    }

    // other methods
}