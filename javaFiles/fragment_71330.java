public class MyRoutingDataSource extends AbstractRoutingDataSource {
   @Override
   protected Object determineCurrentLookupKey() {
      // get the current url
      HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
      if (request.getRequestURL().toString().endsWith("/minor"))
          return "MINOR";
      else
          return "MAJOR";
   }
}