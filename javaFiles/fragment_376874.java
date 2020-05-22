public static void main(String[] args) {
    LocalDateTime localDateTime = LocalDateTime.of(2022, 1 , 25 , 12 , 20 , 33);
    LocalDateTime now = LocalDateTime.now();

    // get the difference in years, months and days (date related difference)
    Period p = Period.between(now.toLocalDate(), localDateTime.toLocalDate());
    // and the difference in hours, minutes and seconds (time-of-day related difference)
    Duration d = Duration.between(now.toLocalTime(), localDateTime.toLocalTime());
    long totalSeconds = d.getSeconds();
    long hours = totalSeconds / 3600;
    long minutes = (totalSeconds % 3600) / 60;
    long seconds = totalSeconds % 60;

    // and print the result(s)
    System.out.println("Difference between " + localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
            + " and " + now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + " is:\n"
            + p.getYears() + " years, " + p.getMonths() + " months, " + p.getDays() + " days, "
            + hours + " hours, " + minutes + " minutes, " + seconds + " seconds");
}