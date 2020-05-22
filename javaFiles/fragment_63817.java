// the following http request headers should NOT have their values
   // returned for security reasons.
   private static final String[] EXCLUDE_HEADERS = {
           "Proxy-Authorization",
           "Authorization"
   };