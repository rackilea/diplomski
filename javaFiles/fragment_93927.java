// maybe some additional annotations
@SpringBootApplication
public class MySpringBootApplication {
    public static void main(String[] args) throws Exception {
       SpringApplication myApp = new SpringApplication(...);
       myApp.setAdditionalProfiles(getOSName());
       myApp.run(args); 
    }

    private static String getOSName() {
     String os = System.getProperty("os.name");
     if (os.toLowerCase().contains("win")) {
         return "windows";      
     }
     else {
          return "linux";
     }
    }
}