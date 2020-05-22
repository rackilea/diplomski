public static LocalTime average(LocalTime t1, LocalTime... others) {
  long nanosSum = t1.toNanoOfDay();
  for (LocalTime other : others) {
    nanoSum += others.toNanoOfDay();
  }
  return LocalTime.ofNanoOfDay(nanoSum / (1+others.length));
}