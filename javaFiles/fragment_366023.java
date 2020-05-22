@Builder
class ExceptionHandler {
    @Singular
    private final List<Class<? extends Exception>> retryTriggers;

    public static ExceptionHandlerBuilder builder() {
        return new ExceptionHandlerBuilder().retryTrigger(Exception.class);
    }
}