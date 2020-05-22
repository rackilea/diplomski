TimeSource<?> clock = () -> PlainTimestamp.of(2015, 8, 1, 10, 24, 5).atUTC();
  String durationInDays =
      PrettyTime.of(Locale.GERMAN).withReferenceClock(clock).printRelative(
          PlainTimestamp.of(2015, 8, 1, 17, 0).atUTC(),
          Timezone.of(EUROPE.BERLIN),
          TimeUnit.DAYS);
  System.out.println(durationInDays); // heute (german word for today)