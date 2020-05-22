public static void main(String... args) {
    System.out.println(
      getDateFromWeekAndYear("53", "2015")); // 2015-12-28, NOT 2014-12-28
    System.out.println(
      getDateFromWeekAndYear("53", "2015").get(WeekFields.ISO.weekOfWeekBasedYear())); // 53
    System.out.println(
      getDateFromWeekAndYear("53", "2014")); // 2014-12-29
    System.out.println(
      getDateFromWeekAndYear("53", "2014").get(WeekFields.ISO.weekOfWeekBasedYear())); // 1
}

private static LocalDate getDateFromWeekAndYear(final String week,final String year) {
    int y = Integer.parseInt(year);
    LocalDate date = LocalDate.of(y, 7, 1); // safer than choosing current date
    // date = date.with(WeekFields.ISO.weekBasedYear(), y); // no longer necessary
    date = date.with(WeekFields.ISO.weekOfWeekBasedYear(), Long.parseLong(week));
    date = date.with(WeekFields.ISO.dayOfWeek(), 1);

    return date;
}