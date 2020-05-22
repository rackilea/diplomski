@Configuration
public class Config {

    @Autowired
    private Bar someBean;

    @Autowired
    private Bar anotherBean;

    @Bean
    @Primary
    public Bar primaryBean() {
        if(someCondition) {
          return someBean;
        } else {
          return anotherBean;
        }
      }

}