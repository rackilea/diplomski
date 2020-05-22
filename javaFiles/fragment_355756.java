// Current time classes:
LocalDate today = LocalDate.now();
// LocalDate today = LocalDate.of(2020, 2, 18);
LocalDateTime morning = today.atStartOfDay();

// Old classes:
Calendar cal = Calendar.getInstance();
cal.setTime(new Date(morning.toEpochSecond()));