LocalTime timecheck = LocalTime.of(10, 29);
LocalTime start = LocalTime.of(10, 0);
LocalTime end = LocalTime.of(10, 30);

if (!start.isAfter(timecheck) && !end.isBefore(timecheck)) {
    ...
}