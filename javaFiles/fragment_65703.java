// This is the parent (main thread)
final Map<String, String> contextMap = MDC.getCopyOfContextMap();

executorService.execute(new Task(contextMap) {
    public final void run() {
        // This is run by the child.
        MDC.setContextMap(contextMap);

        ...
    }
});