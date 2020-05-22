Locale locale = Locale.CANADA_FRENCH;
DayOfWeek firstDayOfWeek = WeekFields.of(locale).getFirstDayOfWeek();

List<DayOfWeek> dows = IntStream.range(0, 7)
        .mapToObj(firstDayOfWeek::plus)
        .collect(Collectors.toList());