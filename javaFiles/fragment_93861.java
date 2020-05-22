LocalDate date = LocalDate.of(2014, 1, 1); // arbitrary date
LocalDateTime tsp = LocalDateTime.of(date, LocalTime.MIDNIGHT);

do {
    System.out.println(tsp.toLocalTime());
    tsp = tsp.plus(Duration.ofHours(8).plusMinutes(10));
} while (date.equals(tsp.toLocalDate()));