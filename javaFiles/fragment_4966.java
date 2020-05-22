public static <E extends Throwable> void attempt(
    Consumer<Function<E,RuntimeException>> action) throws E {

    final class CarryException extends RuntimeException {
        final E carried;
        CarryException(E cause) {
            super(cause);
            carried=cause;
        }
    }

    try { action.accept( CarryException::new ); }
    catch(CarryException ex) { throw ex.carried; }
}