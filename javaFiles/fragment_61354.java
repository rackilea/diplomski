import java.time.{Instant, LocalDate, ZoneOffset}
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

val dtf: DateTimeFormatter = DateTimeFormatter.ISO_DATE
val ld: LocalDate = LocalDate.parse("2017-07-01")
(0 to 29).foreach(i => println(dtf.format(ld.plusDays(i))))