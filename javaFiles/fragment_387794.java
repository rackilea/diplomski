@Test
public void minus0401() {
    DateTime dateTime = new DateTime("2010-10-10T04:00:00",
            DateTimeZone.forOffsetHoursMinutes(-4, 1));
    testDate(dateTime);
}

@Test
public void testIds() {
    List<String> failedIds = new ArrayList<>();
    for (String id : DateTimeZone.getAvailableIDs()) {
        DateTime dateTime = new DateTime("2010-10-10T04:00:00",
                DateTimeZone.forID(id));
        try {
            testDate(dateTime);
        } catch (AssertionError e) {
            failedIds.add(id);
        }
    }
    assertEquals(failedIds.toString(), 0, failedIds.size());
}

@Test
public void testHours() {
    List<Integer> failedHours = new ArrayList<>();
    for (int i = -12; i < 12; i++) {
        DateTime dateTime = new DateTime("2010-10-10T04:00:00",
                DateTimeZone.forOffsetHours(i));
        try {
            testDate(dateTime);
        } catch (AssertionError e) {
            failedHours.add(i);
        }
    }
    assertEquals(failedHours.toString(), 0, failedHours.size());
}

private void testDate(DateTime dateTime) {
    MutableDateTime mutableDateTime = dateTime.toMutableDateTime();
    mutableDateTime.setDate(dateTime);
    assertEquals(dateTime, mutableDateTime.toDateTime());
}