public void printZonesByOffset() {
    DateTime dateTime = DateTime.parse("2012-11-29T23:08:56.23-04:00");
    Set<DateTimeZone> matchingTimeZones = getTimeZonesByOffset(dateTime);
    System.out.println(matchingTimeZones);
}

public Set<DateTimeZone> getTimeZonesByOffset(DateTime dateTime) {
    int dateTimeOffset = dateTime.getZone().getOffset(dateTime);

    Set<String> timeZoneIds = DateTimeZone.getAvailableIDs();
    Set<DateTimeZone> matchingTimeZones = new HashSet<>();
    for (String timeZoneId : timeZoneIds) {
        DateTimeZone timeZone = DateTimeZone.forID(timeZoneId);
        int offset = timeZone.getOffset(dateTime);
        if (dateTimeOffset == offset) {
            matchingTimeZones.add(timeZone);
        }
    }
    return matchingTimeZones;
}