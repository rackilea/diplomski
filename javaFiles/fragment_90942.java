public class UserApiServiceFactory {
   private final static UserApiService service = new UserApiServiceImpl();

   public static UserApiService getUserApi() {
      return service;
   }
}