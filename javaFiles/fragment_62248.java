java.util.Date input = ...;
DateTimeZone zone = DateTimeZone.forID(...);

LocalDate userDate = new LocalDate(input, zone);
boolean exclude = new LocalDate(zone).plusDays(32).isAfter(userDate);

if (exclude) {
  System.out.println("Date should be greater than 32 days in the future.");
}