public interface TimeClient {
   // ...
    static public ZoneId getZoneId (String zoneString) {
        try {
            return ZoneId.of(zoneString);
        } catch (DateTimeException e) {
            System.err.println("Invalid time zone: " + zoneString +"; using default time zone instead.");
            return ZoneId.systemDefault();
        }
    }

   default public ZonedDateTime getZonedDateTime(String zoneString) {
      return ZonedDateTime.of(getLocalDateTime(), getZoneId(zoneString));
   }    
}