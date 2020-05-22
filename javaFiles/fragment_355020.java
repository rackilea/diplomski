@Configuration 
@PropertySource("classpath:mongo.properties")
public class AppConfig{
   // some methods ...
   @Bean
   public Mongo mongo(@Value("${mongo.host.addr}")String host,@Value("${mongo.host.port}")int port){
       return new Mongo(host,port);
   }
   @Bean
   public Morphia morphia(){
      return new Morphia();
   } 
}