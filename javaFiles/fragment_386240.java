class DateTime implements Comparable<DateTime> {
  GregorianCalendar calendar;

  ...

  public int compareTo(DateTime other) {
    if (calendar.equals(other.calendar))
      return 0;
    else if (calendar.before(other.calendar))
      return -1;
    else
      return 1;
  }
}