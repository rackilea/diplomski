ZonedDateTime zdt = ZonedDateTime.parse("2019-11-23T08:43:14.699-07:00[America/Los_Angeles]");
    if (zdt.getMonth().equals(Month.NOVEMBER)
            && zdt.get(ChronoField.ALIGNED_WEEK_OF_MONTH) == 4
            && zdt.getDayOfWeek().equals(DayOfWeek.THURSDAY)) {
        System.out.println("" + zdt + " is on Thanksgiving");
    }