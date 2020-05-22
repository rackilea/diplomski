public static List<LocalDate> makeDateInterval(LocalDate startDate, LocalDate endDate) {
    List<LocalDate> list = new ArrayList<>();
    if (startDate.isAfter(endDate)) {
        return list;
    }
    LocalDate nextDate = startDate;

    while (nextDate.isBefore(endDate)) {
        list.add(nextDate);
        nextDate = nextDate.plusDays(1);
    }
    list.add(endDate);
    return list;
}