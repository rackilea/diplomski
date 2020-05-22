@Configuration
public class Initialize {

   //<snip> Beans created for Developer, and Lawyer objects </snip>

   @Bean
   Map<String, Developer> getDevelopers(List<Developer> developers) {
      return new HashMap<>(...);
   }

   @Bean
   Map<String, Lawyer> getLawyers(List<Person> people) {
      return new HashMap<>(...);
   }

   @Bean
   Map<String, Dog> getOwners(List<Map<String, ? extends Person>> owners) { // Spring will auto-wire the "owners" variable 
                                                                            // with all bean objects that match this signature 
                                                                            // (✅ Map<String, Lawyer>, ✅ Map<String, Developer> ...)

   }

}