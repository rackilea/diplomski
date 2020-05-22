@SpringBootApplication
public class Application{

 @Bean
 public OAuthRestTemplate getAuth(){
   BaseProtectedResourceDetails resourceDetails = new BaseProtectedResourceDetails();
   resourceDetails.set...
   resourceDetails.set...

   return new OAuthRestTemplate(resourceDetails);
 }
}