int minutesUnit = 15;
LocalTime startTime = LocalTime.of(8, 0);
LocalTime endTime = LocalTime.of(10, 0);
Duration duration = Duration.between(startTime, endTime);
long unitsCount = duration.toMinutes() / minutesUnit;
System.out.println(unitsCount);