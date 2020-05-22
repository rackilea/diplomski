import java.time.Instant;
import java.time.ZonedDateTime;
import java.timeZoneOffset;

// ... 

long epoch = Long.parseLong(jsonElement.getAsString()); // Or if you can do jsonElement.getAsLong()
Instant instant = Instant.ofEpochMilli(epoch);
ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, ZoneOffset.UTC); // 2017-03-17T12:11:32Z