@EnableWebSecurity
@Configuration
@ComponentScan(basePackages = { "com.test.smsportal.common.filter" })
public class CustomWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

}