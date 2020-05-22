static <T, R> Function<T, R> wrap(FunException<T, R> fn) {
    return t -> {
        try {
            return fn.apply(t);
        } catch (Error | RuntimeException ex) {
            throw ex;
        } catch (Throwable throwable) {
            throw new RuntimeException("Checked exception in lambda", throwable);
        }
    };
}

interface FunException<T, R> {
    R apply(T t) throws Throwable;
}