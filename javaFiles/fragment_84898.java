public <E extends RuntimeException> void throwOnFail(final boolean result, final Supplier<E> exceptionSupplier) throws E {
    Objects.requireNonNull(exceptionSupplier);
    if (!result) {
        throw exceptionSupplier.get();
    }
}