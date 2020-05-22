public class MyGeneralPurposeSupportHandler implements PlatformSupportHandler {
   private final Set<String> supportedPlatforms;
   public MyGeneralPurposeSupportHandler(Set<String> supportedPlatforms) {
      this.supportedPlatforms = supportedPlatforms;
   } 

   public boolean isPlatformSupported(String platform) {
     return supportedPlatforms.contains(platform);
   }
}

// now in configuration:

@Configuration
class MySpringConfig {

    @Bean
    @Qualifier("discountPlatformSupportHandler") 
    public PlatformSupportHandler discountPlatformSupportHandler() {
       return new MyGeneralPurposeSupportHandler(new HashSefOf({"Android", "iPhone"})); // yeah its not a java syntax, but you get the idea
    }

    @Bean
    @Qualifier("bsafePlatformSupportHandler") 
    public PlatformSupportHandler bsafePlatformSupportHandler() {
       return new MyGeneralPurposeSupportHandler(new HashSefOf({"Android", "iPhone", "iPad"}));
    }   

}