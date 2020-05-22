public class Durations {

  public static Duration getSumOfHoursOnDays(ZoneId zoneId, LocalDateTime dateTimeFrom, LocalDateTime dateTimeTo, LocalTime dailyTimeFrom,
    LocalTime dailyTimeTo) {
    return getDuration(zoneId, dateTimeFrom, dateTimeTo, dailyTimeFrom, dailyTimeTo, ChronoUnit.HOURS);
  }

  public static Duration getDuration(ZoneId zoneId, LocalDateTime dateTimeFrom, LocalDateTime dateTimeTo, LocalTime dailyTimeFrom,
    LocalTime dailyTimeTo, ChronoUnit precision) {
    long count = DateTimeRange.of(dateTimeFrom, dateTimeTo, zoneId)
      .streamOn(precision)
      .filter(getFilter(dailyTimeFrom, dailyTimeTo))
      .count();
    return Duration.of(count, precision);
  }

  protected static Predicate<? super ZonedDateTime> getFilter(LocalTime dailyTimeFrom, LocalTime dailyTimeTo) {
    return dailyTimeFrom.isBefore(dailyTimeTo) ?
      filterFromTo(dailyTimeFrom, dailyTimeTo) :
      filterToFrom(dailyTimeFrom, dailyTimeTo);
  }

  protected static Predicate<? super ZonedDateTime> filterFromTo(LocalTime dailyTimeFrom, LocalTime dailyTimeTo) {
    return zdt -> {
      LocalTime time = zdt.toLocalTime();
      return (time.equals(dailyTimeFrom) || time.isAfter(dailyTimeFrom)) && time.isBefore(dailyTimeTo);
    };
  }

  protected static Predicate<? super ZonedDateTime> filterToFrom(LocalTime dailyTimeFrom, LocalTime dailyTimeTo) {
    return zdt -> {
      LocalTime time = zdt.toLocalTime();
      return (time.equals(dailyTimeFrom) || time.isAfter(dailyTimeFrom)) || (time.isBefore(dailyTimeTo));
    };
  }

}