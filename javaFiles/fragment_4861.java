public static void printStartEndQuarter(int year, int month) {
    double thisMonth = (double)month;
    String quarter = thisMonth/3 <= 1 ? "Quarter 1" : thisMonth/3 <= 2 ? "Quarter 2" : thisMonth/3 <= 3 ? "Quarter 3" : "Quarter 4";
    if (month % 3 == 2) {
        month = month - 1;
    }

    else if (month % 3 == 0) {
        month = month - 2;
    }
    LocalDate start = LocalDate.of(year, month, 1);
    Month endMonth = start.getMonth().plus(2);

    LocalDate end = LocalDate.of(year, endMonth, endMonth.length(start.isLeapYear()));

    System.out.println("Start Date====" + start);
    System.out.println("End Date====" + end);
    System.out.println("quarter====" + quarter);

}