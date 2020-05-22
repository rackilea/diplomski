public class DateUtil {
    private static Clock clock = Clock.systemDefaultZone();

    public static setClock(Clock clock) {
        assertNotProduction();  // optionally check for an environment/system variable to throw exception if used in production
        DateUtil.clock = clock;  
    }

   public static Date getPreviousWorkingDayAsDate() {
      LocalDate today = LocalDate.now(clock);   // use clock
      ...
     return ...;
   }
}