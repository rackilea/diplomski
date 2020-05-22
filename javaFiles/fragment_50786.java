LocalDateTime now = LocalDateTime.now();

// The opening days. Static import these from java.time.DayOfWeek
Set<DayOfWeek> daysOpen = new HashSet<>(Arrays.asList(
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY));
// Opening and closing times
LocalTime timeOpen = LocalTime.of(6, 30);
LocalTime timeClosed = LocalTime.of(17, 0);

if (!daysOpen.contains(now.getDayOfWeek()) || now.toLocalTime().isBefore(timeOpen) || now.toLocalTime().isAfter(timeClosed)) {
    System.out.println("Closed");
}
else {
    System.out.println("Open");
}