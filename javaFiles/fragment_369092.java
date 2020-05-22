LocalDate start = LocalDate.of(2011, Month.DECEMBER, 19);
    LocalDate end = LocalDate.now();
    while (!start.isAfter(end)) {
        System.out.println(start);
        start = start.plusYears(1);
    }
}