@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.test.smsportal.controller", 
"com.test.smsportal.service", "com.test.smsportal.dao",
    "com.test.smsportal.common.filter"})
@Import({CustomWebSecurityConfigurerAdapter.class})
public class MvcConfiguration extends WebMvcConfigurerAdapter {
 //something
}