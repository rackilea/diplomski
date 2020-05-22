private static final AtomicInteger uniqueInvocationNumber = new AtomicInteger();

public static Whatever getData(ValidatedQuery validatedQuery) {
    String aliasName = "TEMPALIAS" + uniqueInvocationNumber.getAndIncrement()
    // build statements, execute statements, deal with results
}