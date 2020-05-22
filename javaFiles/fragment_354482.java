import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.ofEpochMilli(timeInLong),
                                            ZoneId.systemDefault());
System.out.println(zdt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));