LocalDate.parse(
                "201804",
                new DateTimeFormatterBuilder()
                        .appendValue(YEAR, 4)
                        .appendValue(ALIGNED_WEEK_OF_YEAR, 2)
                        .parseDefaulting(WeekFields.ISO.dayOfWeek(), 1).toFormatter()
        );