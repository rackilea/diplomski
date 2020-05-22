static LocalTime stringToTime(String str) {
    String[] components = str.split(":");
    return  LocalTime.of( Integer.valueOf(components[0]), Integer.valueOf(components[1]), Integer.valueOf(components[2]));
}

public static String calculateAverageOfTime(String timeInHHmmss) {
  String[] timesArray = timeInHHmmss.split(" ");

  LocalTime startTime = stringToTime(timesArray[0]);
  LocalTime endTime = stringToTime(timesArray[1]);

  Duration duration = Duration.between(startTime, endTime);
  if (startTime.isAfter(endTime)) {
    duration = duration.plusHours(24);
  }

  LocalTime average = startTime.plus(duration.dividedBy(2L));
  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

  return average.format(dtf);
}