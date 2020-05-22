public static long daysBetweenDatesWithSign(Date d1, Date d2) {
    return daysBetweenDatesWithSign(d1, d2, ZoneId.systemDefault());
}
public static long daysBetweenDatesWithSign(Date d1, Date d2, ZoneId zone) {
    LocalDate instant1 = d1.toInstant().atZone(zone).toLocalDate();
    LocalDate instant2 = d2.toInstant().atZone(zone).toLocalDate();
    return ChronoUnit.DAYS.between(instant1, instant2);
}