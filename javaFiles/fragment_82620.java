@Configuration
public class MyConfig {

   @Bean 
   public Map<String, String> myVal(){
      Map<String, String> map = new HashMap<String, String>();
      map.put("Sample", "Value");      
   }


}