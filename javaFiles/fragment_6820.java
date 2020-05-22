public static List<LocalDate> buildDateRange(LocalDate startDate, LocalDate endDate, LocalDate currentDate) {
    LocalDate firstDate = null;
    LocalDate secondDate = null;

    if (startDate.getMonth() == currentDate.getMonth()) {
        firstDate = startDate;
        secondDate = currentDate;
    }

    if (endDate.getMonth() == currentDate.getMonth()) {
        secondDate = endDate;
        if (firstDate == null) {
            firstDate = currentDate;
        }
    }

    if (firstDate == null || secondDate == null) {
        return new ArrayList<>(); //No valid interval, return empty list
    }

    return makeDateInterval(firstDate, secondDate);
}