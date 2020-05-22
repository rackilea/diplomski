public static boolean dateHasExpired(String dateInput) {
    LocalDate today = LocalDate.now();
    LocalDate dateParsed = null;

    if (dateInput.contains("/")) {
        // parse credit card expiration date
        YearMonth ym = YearMonth.parse(dateInput, DateTimeFormatter.ofPattern("MM/yy"));
         // get last day of month (taking care of leap years)
        dateParsed = ym.atEndOfMonth();
    } else {
        // parse funding expiration date
        dateParsed = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    // expired if today is equals or after dateParsed
    return ! today.isBefore(dateParsed);
}