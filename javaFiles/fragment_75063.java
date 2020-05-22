public static String getDay(String day, String month, String year) {
    return LocalDate.of(
            Integer.parseInt(year),
            Integer.parseInt(month),
            Integer.parseInt(day)
    ).getDayOfWeek().toString();
}