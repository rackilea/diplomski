String lastDate = "2017-10-17T04:11:51+00:00";
OffsetDateTime odt = OffsetDateTime.parse(lastDate);
// get difference from now (in minutes)
long diff = ChronoUnit.MINUTES.between(odt.toInstant(), Instant.now());
if (diff > 20) {
    // odt is more than 20 minutes ago
}