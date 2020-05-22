public static ZoneOffset parseOffset(Clock now, String serviceLocal) {
  LocalTime serverTime = LocalTime.parse(serviceLocal);
  LocalTime localTime = LocalTime.now(now);

  LocalTime adjustedServerTime = getAccurateServerTime(serverTime, localTime, 10);

  int seconds = getSecondsOffset(localTime, adjustedServerTime);
  return ZoneOffset.ofTotalSeconds(seconds);
}

/**
 *
 * @param actual the time on the server (may be inaccurate by 10 seconds)
 * @param accurate the accurate local time , may be a in a different time zone
 * @param maxSecondsInaccuracy the maximum inaccuracy of the time on the server in seconds
 * @return the server time, adjusted for seconds inaccuracy
 */
private static LocalTime getAccurateServerTime(LocalTime actual, LocalTime accurate, int maxSecondsInaccuracy) {
  int actualSeconds = actual.getSecond();
  int accurateSeconds = accurate.getSecond();
  if (Math.abs(actualSeconds - accurateSeconds) < maxSecondsInaccuracy) {
    return actual.withSecond(accurateSeconds);
  } else { //not in the same minute
    if (actualSeconds < accurateSeconds) {
      return actual.minusMinutes(1).withSecond(accurateSeconds);
    } else {
      return actual.plusMinutes(1).withSecond(accurateSeconds);
    }
  }
}

/**
 * @return the offset between the two times, in seconds, between -12 and +12
 */
private static int getSecondsOffset(LocalTime target, LocalTime serverTime) {
  Duration d = Duration.between(target, serverTime);
  long minutes = d.toMinutes();

  //limit offset to -12/+12
  if (minutes < -12 * 60) minutes = minutes + 24 * 60;
  if (minutes > 12 * 60) minutes = minutes - 24 * 60;
  return (int) (minutes * 60);
}