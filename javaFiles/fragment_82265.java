public static void main(String[] args) {
  LocalTime t = LocalTime.of(12, 34);
  LocalTime next15 = t.with(next15Minute());
  System.out.println(next15.minusMinutes(14) + " - " + next15);
}

public static TemporalAdjuster next15Minute() {
  return (temporal) -> {
    int minute = temporal.get(ChronoField.MINUTE_OF_DAY);
    int next15 = (minute / 15 + 1) * 15;
    return temporal.with(ChronoField.NANO_OF_DAY, 0).plus(next15, ChronoUnit.MINUTES);
  };
}