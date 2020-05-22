LocalTime startTime = LocalTime.parse("11:00 PM", DateTimeFormatter.ofPattern("KK:mm a"));
LocalTime endTime = LocalTime.parse("02:00 AM", DateTimeFormatter.ofPattern("KK:mm a"));

LocalTime selected = LocalTime.parse("01:00 AM", DateTimeFormatter.ofPattern("KK:mm a"));

if (startTime.isBefore(endTime)) {
    if (selected.isAfter(startTime) && selected.isBefore(endTime)) {
        System.out.println("It works!");
    }
} else if (startTime.isAfter(endTime)) {
    if (selected.isAfter(startTime) || selected.isBefore(endTime)) {
        System.out.println("It works!");
    }
} else {
    // Decide what to do if startTime and endTime are equal.
}