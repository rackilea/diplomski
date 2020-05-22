.filter(l -> {
    LocalTime startTime = LocalTime.parse(l.get("startTime"));
    LocalTime endTime = LocalTime.parse(l.get("endTime"));

    LocalTime currentTime = LocalTime.now(Clock.systemUTC());
    return startTime.isBefore(endTime)
            ? currentTime.isAfter(startTime) && currentTime.isBefore(endTime)
            : currentTime.isAfter(startTime) || currentTime.isBefore(endTime);
})