class HourDeltaCalculator {

  // assuming you want month first like in US-date-format?
  private static final DateTimeFormatter FORMATTER = 
    DateTimeFormat.forPattern("MM/dd/yyyy H:mm"); 

  public static int hoursBetween(String date1, String date2) {
    LocalDateTime ldt1 = FORMATTER.parseLocalDateTime(date1);
    LocalDateTime ldt2 = FORMATTER.parseLocalDateTime(date2);

    return Hours.hoursBetween(ldt1, ldt2).getHours();
  }
}