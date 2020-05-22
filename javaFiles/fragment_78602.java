LocalDate today = LocalDate.now(ZoneId.of("Europe/London"));
        int year = today.getYear();
        DayOfWeek weekday = today.getDayOfWeek();

        System.out.println(year);
        System.out.println(weekday);