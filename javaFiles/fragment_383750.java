OffsetDateTime target, eta;    // Modern java.time class.
java.util.Date scheduledDate;  // Terrible legacy class.


if(Objects.isNull(eta)) {   // If no eta, fall back to scheduledDate.
    target = scheduledDate.toInstant().atOffset( ZoneOffset.UTC ); // Never use legacy class `java.util.Date` -- when encountered, immediately convert to modern `java.time.Instant`. 
} else {  // Else not null.
    target = eta;
}
return target;