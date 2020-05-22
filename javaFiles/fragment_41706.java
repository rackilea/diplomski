public void days_between_two_dates_in_java_with_java8 () {

    LocalDate startDate = LocalDate.now().minusDays(1);
    LocalDate endDate = LocalDate.now();

    long days = Period.between(startDate, endDate).getDays();


    // or 

    long days2 = ChronoUnit.DAYS.between(startDate, endDate);

}