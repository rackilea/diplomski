// Matlab epoch is January 0, 0000, so subtract 1 day from January 1:
    Instant matlabEpoch = Instant.parse("0000-01-01T00:00:00Z").minus(1, ChronoUnit.DAYS);

    Instant inst = matlabEpoch.plusMillis(
            Math.round(732161.8561226851 * TimeUnit.DAYS.toMillis(1)));
    System.out.println(inst);