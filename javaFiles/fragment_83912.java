LocalDateTime oldDate = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC);

// Thread.sleep(2000);

LocalDateTime replaced = LocalDateTime.ofInstant(Instant.now(), ZoneOffset.UTC)
                             .withHour(oldDate.getHour())
                             .withMinute(oldDate.getMinute())
                             .withSecond(oldDate.getSecond())
                             .withNano(oldDate.getNano());

    System.out.printf("Old date: %s  Replaced date: %s", oldDate, replaced);