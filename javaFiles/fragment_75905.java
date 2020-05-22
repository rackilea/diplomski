LocalDate lastVisible = LocalDate.of(2017, 3, 12);
LocalDate dateToSelect = LocalDate.of(2017, 3, 13);

long weeks = ChronoUnit.WEEKS.between(lastVisible, dateToSelect);
System.out.println("number of weeks "+ weeks);

dateToSelect = LocalDate.of(2017, 3, 19);
weeks = ChronoUnit.WEEKS.between(lastVisible, dateToSelect);
System.out.println("number of weeks "+ weeks);

// to get number of weeks regardless of going forward or backwards in time
dateToSelect = LocalDate.of(2017, 3, 20);
weeks = Math.abs(ChronoUnit.WEEKS.between(dateToSelect, lastVisible));
System.out.println("number of weeks "+ weeks);