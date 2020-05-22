import java.time.{LocalDateTime, ZoneId}
import java.time.temporal.ChronoUnit

val dateOfInterest = LocalDateTime.parse("2020-02-02T12:00")

ChronoUnit.HOURS.between(dateOfInterest.atZone(ZoneId.of("Europe/Paris"))
                        ,dateOfInterest.atZone(ZoneId.of("America/Los_Angeles")))
//res0: Long = 9