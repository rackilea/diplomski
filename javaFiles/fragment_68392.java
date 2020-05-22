Instant msFiletimeEpoch = Instant.parse("1601-01-01T00:00:00Z");
    // a tick is 100 nanoseconds
    int nanosPerTick = 100;
    long ticksPerSecond = TimeUnit.SECONDS.toNanos(1) / nanosPerTick;

    long fullval = 130_280_867_040_000_000L;

    long seconds = fullval / ticksPerSecond;
    long nanos = fullval % ticksPerSecond * nanosPerTick;

    Instant answer = msFiletimeEpoch.plusSeconds(seconds).plusNanos(nanos);

    System.out.println(answer);