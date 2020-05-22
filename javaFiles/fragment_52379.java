customer.getDateOfBirth()                     // Assuming this call returns a `XMLGregorianCalendar`. 
    .toGregorianCalendar​()                    // Convert `XMLGregorianCalendar` to the legacy class `GregorianCalendar`, en route to a `ZonedDateTime` in next line.
    .toZonedDateTime()                        // Convert from `GregorianCalendar` to `ZonedDateTime`, from legacy class to modern class.
    .toOffsetDateTime()                       // Convert to `OffsetDateTime` to better document that we are moving to an offset-from-UTC rather than a full time zone.
    .withOffsetSameInstant( ZoneOffset.UTC )  // Adjust into UTC. Same moment in time, same point on the timeline, but viewed through a different wall-clock time.
    .toLocalDate()                            // Extract a date-only value, without time zone and without time-of-day.
    .toString()                               // Generate a string in standard ISO 8601 format YYYY-MM-DD.
;