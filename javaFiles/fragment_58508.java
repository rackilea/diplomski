YearMonth yearMonthObject = YearMonth.of(year, month);
int daysOfCurrentMonth = yearMonthObject.lengthOfMonth();

ArrayList<LocalDate> dayes = new ArrayList<LocalDate>();
for(int i = 1; i <= daysOfCurrentMonth; i++){
    dayes.add(yearMonthObject.atDay(i));
}

dayes.forEach(value -> System.out.println(value.getDayOfMonth() + " " + value.getDayOfWeek()));