@Test
public void testDateFormat(){
    DateTimeFormatter formatter= new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd-MMM-yyyy HH:mm:ss").toFormatter();
    LocalDateTime dateTime = LocalDateTime.parse("04-NOV-2015 16:00:00", formatter);
    System.out.println(dateTime.getYear());
}