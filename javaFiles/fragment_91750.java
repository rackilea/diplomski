public class MyService {

   @Value("#{request}")
   private HttpServletRequest request;

   public void assertHasRequest() {// no parameters here because they don't act on local field this.request
       assertNotNull(this.request);
   }
}