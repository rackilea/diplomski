LocalTime ten = LocalTime.parse("22:00:00");
LocalTime twelve = LocalTime.parse("23:59:59");

// current time
LocalTime now = LocalTime.now();

// compare
if (now.isBefore(twelve) && now.isAfter(ten)) {
    // succcess
}