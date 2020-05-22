// Coptic calendar
CopticChronology cal = CopticChronology.INSTANCE;
// range for month of year (from 1 to 13)
System.out.println("month range: " + cal.range(ChronoField.MONTH_OF_YEAR)); // 1 - 13

// getting a date in Coptic calendar and loop through the months
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
// September 11th is equivalent to 01/01 in Coptic calendar
CopticDate d = cal.date(LocalDate.of(2017, 9, 11));
for (int i = 0; i < 14; i++) {
    System.out.println(fmt.format(d));
    d = d.plus(1, ChronoUnit.MONTHS);
}