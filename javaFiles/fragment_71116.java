@Configuration
@PropertySource(value="classpath*:app.properties")
public class AppConfig {
 @Autowired
 Environment env;

 @Bean
 public TestBean testBean() {
     TestBean testBean = new TestBean();
     testBean.setName(env.getProperty("testbean.name"));
     return testBean;
 }
}