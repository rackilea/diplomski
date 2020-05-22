synchronized (timestampLock) {
    this.timestamp = java.sql.Timestamp.from(dateTime.toInstant());
    //CONTEXT SWITCH HERE
    this.timestampTimeZoneName = dateTime.getZone().getId();
}

synchronized (timestampLock) {
    return ZonedDateTime.ofInstant(timestamp.toInstant(), ZoneId.of(timestampTimeZoneName));
}