public Duration getTimeUntilNext(DayOfWeek currentDay, LocalTime currentTime) {
        int daysUntil = day.getValue() - currentDay.getValue();
        Duration time = Duration.ofDays(daysUntil).plus(Duration.between(currentTime, startTime));
        if (time.isNegative()) { // over for this week
            // Calculate time until next week’s occurrence
            time = time.plusDays(7);
            assert ! time.isNegative() : time;
        }
        return time;
    }