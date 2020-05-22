@Test
public void testLocalDateTime() throws Exception {

    DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd-MMM-yyyy").toFormatter(Locale.US);

    Tcan1990 applicant = tcan1990Repository.findOne(new Tcan1990PK("000000009", 888067));

    assertEquals(LocalDate.parse("10-APR-1990", formatter).atStartOfDay(), applicant.getPymtDt());

}