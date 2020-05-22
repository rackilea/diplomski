ZoneId zone = ZoneId.of("Europe/Guernsey");  // Specify a time zone by proper name `Contintent/Region`, never by 3-4 letter codes such as `PST`, `CST`, or `IST`.
LocalDate then =                             // Represent a date-only value, without time zone and without time-of-day.
    Instant.ofEpochMilli(1_512_431_637_067L) // Parse your number of milliseconds since 1970-01-01T00:00Z as a value in UTC.
           .atZone(zone)                     // Adjust from UTC to some other zone. Same moment, different wall-clock time. Returns a `ZonedDateTime`.  
           .toLocalDate();                   // Extract a date-only value.
LocalDate today = LocalDate.now(zone);       // Get the current date as seen in the wall-clock time in use by the people of a particular region.
Period diff = Period.between(then, today);   // Determine the number of years-months-days elapsed.
System.out.println(diff);                    // Generate a String is standard ISO 8601 format: `PnYnMnDTnHnMnS`.