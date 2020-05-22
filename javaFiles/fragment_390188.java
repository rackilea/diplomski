class AjaxTimeoutFilters {

   int sessionTimeout = 30 * 60 * 1000
   private static final String TIMEOUT_KEY = 'TIMEOUT_KEY'

   def filters = {
      all(controller:'*', action:'*') {
         before = {
            if (request.xhr) {
               Long lastAccess = session[TIMEOUT_KEY]
               if (lastAccess == null) {
                  // TODO
                  return false
               }
               if (System.currentTimeMillis() - lastAccess > sessionTimeout) {
                  session.invalidate()
                  // TODO - render response to trigger client redirect
                  return false
               }
            }
            else {
               session[TIMEOUT_KEY] = System.currentTimeMillis()
            }

            true
         }
      }
   }
}