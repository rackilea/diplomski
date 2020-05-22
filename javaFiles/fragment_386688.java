public void requestDestroyed(ServletRequestEvent requestEvent) {
   ServletRequestAttributes attributes =
           (ServletRequestAttributes) requestEvent.getServletRequest().getAttribute(REQUEST_ATTRIBUTES_ATTRIBUTE);
   ServletRequestAttributes threadAttributes =
           (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
   if (threadAttributes != null) {
       // We're assumably within the original request thread...
       if (attributes == null) {
           attributes = threadAttributes;
       }
       RequestContextHolder.resetRequestAttributes();
       LocaleContextHolder.resetLocaleContext();
   }
   if (attributes != null) {
       attributes.requestCompleted();
       if (logger.isDebugEnabled()) {
           logger.debug("Cleared thread-bound request context: " + requestEvent.getServletRequest());
       }
   }
}