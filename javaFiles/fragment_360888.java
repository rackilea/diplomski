public class DateTest {
    private static final int HOUR_TO_TEST = 2;

  public static void main(String[] args) {
    DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
    DateTime startOfDay = dtf.parseDateTime("30/03/2008 00:00:00");

    /* Obtained from new DateTime() in code in practice */
    DateTime actualTimeWhenStoring = startOfDay.plusHours(HOUR_TO_TEST);

    int hourOfDay = actualTimeWhenStoring.getHourOfDay();
    int hourOffset = startOfDay.plusHours(hourOfDay).getHourOfDay();

    System.out.println("Hour of day:" + hourOfDay);
    System.out.println("Offset hour:" + hourOffset);

    int timeToSave = hourOfDay;
    if (hourOffset != hourOfDay) {
        timeToSave = (hourOfDay + (hourOfDay - hourOffset));
    }
    System.out.println("Time to save:" + timeToSave);

    /* When obtaining from db: */
    DateTime recalculatedTime = startOfDay.plusHours(timeToSave);

    System.out.println("Hour of time 'read' from db:" + recalculatedTime.getHourOfDay());
  }
}