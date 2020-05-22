283                       try {
  284                           cookies = HttpCookie.parse(headerValue);
  285                       } catch (IllegalArgumentException e) {
  286                           // Bogus header, make an empty list and log the error
  287                           cookies = java.util.Collections.EMPTY_LIST;
  288                           if (logger.isLoggable(PlatformLogger.SEVERE)) {
  289                               logger.severe("Invalid cookie for " + uri + ": " + headerValue);
  290                           }
  291                       }