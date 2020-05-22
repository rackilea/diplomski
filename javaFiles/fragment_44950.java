void test(){
    var tz = ZoneId.of("CET");
    var anyDate = LocalDate.of(2019,12,4);

    var x = ZonedDateTime.of(LocalDateTime.of(anyDate, LocalTime.of(18,59)),tz).toInstant();

    System.out.println(testTime(Clock.fixed( ZonedDateTime.of(LocalDateTime.of(anyDate, LocalTime.of(18,59)),tz).toInstant(),tz)));
    System.out.println(testTime(Clock.fixed( ZonedDateTime.of(LocalDateTime.of(anyDate, LocalTime.of(19,01)),tz).toInstant(),tz)));
    System.out.println(testTime(Clock.fixed( ZonedDateTime.of(LocalDateTime.of(anyDate, LocalTime.of(00,00)),tz).toInstant(),tz)));
    System.out.println(testTime(Clock.fixed( ZonedDateTime.of(LocalDateTime.of(anyDate, LocalTime.of(02,59)),tz).toInstant(),tz)));
    System.out.println(testTime(Clock.fixed( ZonedDateTime.of(LocalDateTime.of(anyDate, LocalTime.of(03,01)),tz).toInstant(),tz)));
}

boolean testTime(Clock clock){
    var evening =LocalTime.of(19,00);
    var midnight =LocalTime.of(00,00);
    var night =LocalTime.of(03,00);

    LocalTime wallTime = LocalTime.now(clock);

    return (wallTime.isAfter(evening) && wallTime.isBefore(midnight.minusNanos(1))) ||  (midnight.isBefore(wallTime) && wallTime.isBefore(night)) || wallTime.equals(midnight);

}