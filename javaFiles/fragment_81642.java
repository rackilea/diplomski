public static Timestamp from(Instant instant) {
    try {
        Timestamp stamp = new Timestamp(instant.getEpochSecond() * MILLIS_PER_SECOND);
        stamp.nanos = instant.getNano();
        return stamp;
    } catch (ArithmeticException ex) {
        throw new IllegalArgumentException(ex);
    }
}