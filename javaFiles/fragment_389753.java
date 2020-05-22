LocalTime orig = LocalTime.of(0, 30);
    int minutesToSubtract = 35;
    long minutesSinceMidnight = ChronoUnit.MINUTES.between(LocalTime.MIN, orig);
    LocalTime result;
    if (minutesToSubtract > minutesSinceMidnight) {
        // Subtracting the minutes will pass midnight at start of day
        result = LocalTime.MIN;
    } else {
        // Normal case, no underflow
        result = orig.minusMinutes(minutesToSubtract);
    }
    System.out.println(result);