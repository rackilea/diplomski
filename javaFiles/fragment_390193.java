LocalDate msBaseDate = LocalDate.of(1899, Month.DECEMBER, 30);
    int[] integers = { 4305, 4304, 4303 };
    for (int integerValue : integers) {
        LocalDate date = msBaseDate.plusDays(integerValue);
        System.out.println(date);
    }