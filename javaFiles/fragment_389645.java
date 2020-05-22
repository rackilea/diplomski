// ... imports 
@Configuration
@EnableWebMvc
@EnableScheduling
@PropertySources({
    @PropertySource("classpath:app.properties")
    // ... Properties sources
})
@EnableTransactionManagement
@ComponentScan(basePackages = "com.our.package")
public class SpringConfiguration extends WebMvcConfigurerAdapter {

 // Our Spring configuration ...

}