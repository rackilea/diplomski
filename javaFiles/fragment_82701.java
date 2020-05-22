public class MyRestAppResponseFilter implements ContainerResponseFilter {

        @Override
        public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
                throws IOException {

            // Remove StackTrace from all exceptions
            Object entity = responseContext.getEntity();
    if (entity instanceof Throwable) {
                responseContext.setEntity(null);
                responseContext.setStatus(Response.Status.BAD_REQUEST.getStatusCode());
 }           
            // TF-246 Prevent caching for privacy reasons
            responseContext.getHeaders().add("Cache-Control", "no-cache, no-store, must-revalidate");
            responseContext.getHeaders().add("Pragma", "no-cache");
            responseContext.getHeaders().add("Expires", "Thu, 01 Jan 1970 01:00:00 CET");

            // TF-752 Enable CORS for WkWebView
            responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
        }
    }