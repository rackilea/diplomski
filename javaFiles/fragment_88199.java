@Configuration
// optional @ComponentScan(basePackages = {"name.your.package.here"}
public class AppConfig
{
    @Bean // or @Bean(name = "nameOfYourBean")
    public ResourcePool getResourcePool() 
    { 
        return new ResourcePool(); 
    }
}