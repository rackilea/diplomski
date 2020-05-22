public boolean iBusinessDayToday() {
  return iBusinessDayToday(Clock.systemDefaultZone());
}

@VisibleForTesting
boolean iBusinessDayToday(Clock clock) {
      LocalDate today = LocalDate.now(clock);
      //logic with today
}