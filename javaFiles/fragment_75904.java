LocalDate lastVisible = LocalDate.of(2017, 3, 12);
LocalDate dateToSelect = LocalDate.of(2017, 3, 13).minusDays(1);

long weeks = ChronoUnit.WEEKS.between(lastVisible, dateToSelect);
System.out.println("number of weeks "+ weeks);

dateToSelect = LocalDate.of(2017, 3, 19).minusDays(1);
weeks = ChronoUnit.WEEKS.between(lastVisible, dateToSelect);
System.out.println("number of weeks "+ weeks);

dateToSelect = LocalDate.of(2017, 3, 20).minusDays(1);
weeks = ChronoUnit.WEEKS.between(lastVisible, dateToSelect);
System.out.println("number of weeks "+ weeks);