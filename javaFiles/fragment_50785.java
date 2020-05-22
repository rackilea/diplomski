LocalTime open = LocalTime.of(6, 30);
LocalTime closed = LocalTime.of(17, 0);

LocalTime currentTime = LocalTime.now();
if (currentTime.isBefore(open) || currentTime.isAfter(closed)) {
    // Closed
}