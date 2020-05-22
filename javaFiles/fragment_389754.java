public static LocalTime addWithoutOverflow(LocalTime baseTime, int minutes) {
    LocalTime maxTime = LocalTime.MAX;
    long maxNanos = ChronoUnit.NANOS.between(baseTime, maxTime);
    long nanos = Duration.ofMinutes(minutes).toNanos();
    return baseTime.plusNanos(Math.min(maxNanos, nanos));
}