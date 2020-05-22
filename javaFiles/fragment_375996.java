long fromBytes = -8_586_803_256_090_942_249L;
    // Reverse sign bit
    fromBytes = fromBytes ^ 0x8000_0000_0000_0000L;
    Instant cSharpEpoch = Instant.parse("0001-01-01T00:00:00Z");
    // 100 nanosecond units or 10^-7 seconds
    final int unitsPerSecond = 10_000_000;
    long seconds = fromBytes / unitsPerSecond;
    long nanos = (fromBytes % unitsPerSecond) * 100;
    Instant inst = cSharpEpoch.plusSeconds(seconds).plusNanos(nanos);
    System.out.println("Result instant: " + inst);
    ZonedDateTime dateTime = inst.atZone(ZoneId.of("Asia/Jakarta"));
    System.out.println("Result time in Western Indonesia: " + dateTime);