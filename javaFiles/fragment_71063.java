import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZOneId;
import java.time.format.DateTimeFormatter;

ZoneId zone = ZoneId.of("Australia/Sydney");
LocalDateTime ldt = LocalDateTime.parse("2019-01-01T18:46:19") ;
ZonedDateTime zdt = ZonedDateTime.of(ldt, zone);
DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm a z dd/MM/yy");
System.out.println(dtf.format(zdt));