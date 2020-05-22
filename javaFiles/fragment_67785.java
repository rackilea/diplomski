public static boolean isOpen(LocalTime start, LocalTime end, LocalTime time) {
  if (start.isAfter(end)) {
    return !time.isBefore(start) || !time.isAfter(end);
  } else {
    return !time.isBefore(start) && !time.isAfter(end);
  }
}