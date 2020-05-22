private static void testDateParsing() {
    ZonedDateTime zdt = ZonedDateTime.parse("2019-08-28T10:39:57+08:00", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZZZZZ"));
    ZonedDateTime modifiedZdt = zdt.withZoneSameInstant(ZoneId.systemDefault());
    System.out.println(zdt);
    System.out.println(modifiedZdt);
    System.out.println(LocalDateTime.from(zdt));
    System.out.println(LocalDateTime.from(modifiedZdt));
}