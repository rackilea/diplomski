private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy[' ']['T'][H:mm[:ss[.S]]][X]");

public LocalDate getRobustLocalDate(String value) {
    try {
        return LocalDate.parse(value, formatter);
    } catch (DateTimeParseException e) {
        return null;
    }
}

@Test
public void testDates() {
    getRobustLocalDate("03/07/2016");               // 2016-07-03
    getRobustLocalDate("3/7/2016");                 // 2016-07-03
    getRobustLocalDate("3/7/2016 00:00:00");        // 2016-07-03
    getRobustLocalDate("3/7/2016 00:00:00.0+0100"); // 2016-07-03
    getRobustLocalDate("3/7/2016T00:00:00.0+0100"); // 2016-07-03
}