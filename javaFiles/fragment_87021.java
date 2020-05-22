@Configuration
@ComponentScan(basePackages = { "org.example" })
@Import({MyApplicationContext.class, EndpointWebMvcAutoConfiguration.class, 
  ManagementServerPropertiesAutoConfiguration.class, EndpointAutoConfiguration.class, 
  HealthIndicatorAutoConfiguration.class})
@PropertySource("classpath:app.properties")
@EnableWebMvc
public class MyWebApplicationContext {
...
}