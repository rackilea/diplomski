import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

// testing in the same timezone
ZoneId sp = ZoneId.of("America/Sao_Paulo");
// savedDate: 22/05/2017 10:00 in Sao Paulo timezone
Instant savedDate = ZonedDateTime.of(2017, 5, 22, 10, 0, 0, 0, sp).toInstant();
// 1 nanosecond before expires (returns false - not expired)
System.out.println(hasDateExpired(3, savedDate, ZonedDateTime.of(2017, 5, 25, 9, 59, 59, 999999999, sp).toInstant()));
// exactly 3 days (72 hours) after saved date (returns false - not expired)
System.out.println(hasDateExpired(3, savedDate, ZonedDateTime.of(2017, 5, 25, 10, 0, 0, 0, sp).toInstant()));
// 1 nanosecond after 3 days (72 hours) (returns true - expired)
System.out.println(hasDateExpired(3, savedDate, ZonedDateTime.of(2017, 5, 25, 10, 0, 0, 1, sp).toInstant()));

// testing in different timezones (savedDate in Sao Paulo, currentDate in London)
ZoneId london = ZoneId.of("Europe/London");
// In 22/05/2017, London will be in summer time, so 10h in Sao Paulo = 14h in London
// 1 nanosecond before expires (returns false - not expired)
System.out.println(hasDateExpired(3, savedDate, ZonedDateTime.of(2017, 5, 25, 13, 59, 59, 999999999, london).toInstant()));
// exactly 3 days (72 hours) after saved date (returns false - not expired)
System.out.println(hasDateExpired(3, savedDate, ZonedDateTime.of(2017, 5, 25, 14, 0, 0, 0, london).toInstant()));
// 1 nanosecond after 3 days (72 hours) (returns true - expired)
System.out.println(hasDateExpired(3, savedDate, ZonedDateTime.of(2017, 5, 25, 14, 0, 0, 1, london).toInstant()));