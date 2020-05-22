public class MySecurityConfiguration extends WebSecurityConfigurerAdapter {

 @Autowired
 DataSource dataSource;

 @Autowired
 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {