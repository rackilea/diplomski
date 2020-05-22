public static void main(String[] args) {
    Instant a = Instant.ofEpochSecond(1511928000L); // 11/29/17 4 AM
    Instant b = Instant.ofEpochSecond(1511935200L); // 11/29/17 6 AM
    ZoneId localZone = ZoneId.of("America/New_York"); // Can be any zone ID

    if (isBOneDayAfterA(a, b, localZone)) {
        System.out.println("b is one day after a!");
    } else {
        System.out.println("b is NOT one day after a");
    }
}

public static boolean isBOneDayAfterA(Instant a, Instant b, ZoneId localZone) {
    LocalDateTime aAdjusted = LocalDateTime.ofInstant(a, localZone);
    LocalDateTime bAdjusted = LocalDateTime.ofInstant(b, localZone);
    LocalDate aDate = aAdjusted.toLocalDate();
    LocalDate bDate = bAdjusted.toLocalDate();

    return bDate.minusDays(1).equals(aDate);
}