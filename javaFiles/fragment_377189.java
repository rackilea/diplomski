public static Runnable withMdc(Runnable runnable) {
    Map<String, String> mdc = MDC.getCopyOfContextMap();
    return () -> {
        MDC.setContextMap(mdc);
        runnable.run();
    };
}

public static <U> Supplier<U> withMdc(Supplier<U> supplier) {
    Map<String, String> mdc = MDC.getCopyOfContextMap();
    return (Supplier) () -> {
        MDC.setContextMap(mdc);
        return supplier.get();
    };
}