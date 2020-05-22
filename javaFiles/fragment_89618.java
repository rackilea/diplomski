@Configuration
@EnableAspectJAutoProxy
@EnableSwagger2
@EnableWebMvc
@PropertySource("classpath:test.properties")
@ComponentScan(basePackages = {"com.test.web"})
public class UmwWebConfig implements WebMvcConfigurer { ... }