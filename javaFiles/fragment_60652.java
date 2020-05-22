/**
 * 
 * @param dateTimeString String in 20170609T184237Z format
 * @return milliseconds since the epoch as String
 * @throws IllegalArgumentException if the String is not in the correct format
 */
private static String isoToEpochMillis(String dateTimeString) {
    try {
        OffsetDateTime dateTime = OffsetDateTime.parse(dateTimeString,
                DateTimeFormatter.ofPattern("uuuuMMdd'T'HHmmssX"));
        if (! dateTime.getOffset().equals(ZoneOffset.UTC)) {
            throw new IllegalArgumentException("Offset is not Z");
        }
        return String.valueOf(dateTime.toInstant().toEpochMilli());
    } catch (DateTimeException dte) {
        throw new IllegalArgumentException("String is not in format uuuuMMddTHHmmssZ",
                                           dte);
    }
}