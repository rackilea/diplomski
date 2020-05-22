LocalDate startDate = LocalDate.now();
LocalDate endDate = startDate.plusMonths(1);

List<LocalDate> weekends = findWeekendsBetween(startDate.toEpochDay(), endDate.toEpochDay());
System.out.println("Found " + weekends.size() + " Saturday/Sundays");
for (LocalDate date : weekends) {
    System.out.println(date);
}