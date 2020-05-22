@Service
 public AppUserService {

   public static AppUserService instance;

   public AppUserService() {
     // Modify the constructor setting a static variable holding a
     // reference to the instance created by spring
     AppUserService.instance = this;
   }

   ...
 }