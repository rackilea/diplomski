@Test
public void testDateTimeConversion() {
    final Date sourceDateTime = new DateTime(2015, 3, 15, 12, 55, TIMEZONE_MOSCOW).toDate();
    final Date expectedResult =
        new DateTime(2015, 3, 15, 12 - 2, 55, TIMEZONE_BERLIN).toLocalDateTime().toDate();

    final DateTime timeInMoscow =
        new DateTime(sourceDateTime, TIMEZONE_MOSCOW);
    final DateTime timeInBerlin = timeInMoscow.toDateTime(TIMEZONE_BERLIN);
    final Date actualResult = timeInBerlin.toLocalDateTime().toDate();

    Assert.assertEquals(expectedResult, actualResult);
}