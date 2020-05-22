public static void main(String[] args) {
    LocalDateTime localDateTime = LocalDateTime.of(2022, 1 , 25 , 12 , 20 , 33);
    LocalDateTime now = LocalDateTime.now();

    // get the difference in years, months and days
    Period p = Period.between(now.toLocalDate(), localDateTime.toLocalDate());

    // and print the result(s)
    System.out.println("Difference between " + localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
            + " and " + now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + " is:\n"
            + p.getYears() + " years, " + p.getMonths() + " months, " + p.getDays() + " days");
}