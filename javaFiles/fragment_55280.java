@Configuration
public class LocationConfiguration {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Location myLocation(){
        return new Location("US","California","Some peacefull town","Some peacefull street",1);
    }
}