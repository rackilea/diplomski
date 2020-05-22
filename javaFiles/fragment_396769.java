@Configuration
public class AppConfig {

   @Autowired
   Dao dao;

   @Bean
   @Scope(value = "prototype")
   public FixedLengthReport fixedLengthReport(String sourceSystem) {
       return new TdctFixedLengthReport(sourceSystem, dao);
   }
}