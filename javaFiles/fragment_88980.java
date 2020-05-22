public class SupportHandler {

   private final Map<String, Set<String>> platformTypeToSuportedPlatforms;

   public SupportHandler(Map<String, Set<String>> map) {
       this.platformTypeToSupportedPlatforms = map; 
   }

   public boolean isPaltformSupported(String type) {
        Set<String> supportedPlatforms = platformTypeToSupportedPlatforms.get(type);
        if(supportedPlatforms == null) {
          return false; // or maybe throw an exception, the point is that you don't deal with spring here which is good since spring shouldn't interfere with your business code
        }
        return supportedPlatforms.contains(type);

   }
}

@Configuration 
public class MyConfiguration {

    // Configuration conf is supposed to be your own way to read configurations in the project - so you'll have to implement it somehow
    @Bean
    public SupportHandler supportHandler(Configuration conf) {
      return new SupportHandler(conf.getRequiredMap());
    }
}