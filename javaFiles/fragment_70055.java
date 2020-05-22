Instant todayMidnight = new DateMidnight().toInstant();
Instant earliest = todayMidnight.plus(Hours.hours(6).toStandardDuration());
Instant latest = todayMidnight.plus(Hours.hours(15).toStandardDuration());
if (latest.isAfterNow() && earliest.isBeforeNow()) {
  // Execute 
}