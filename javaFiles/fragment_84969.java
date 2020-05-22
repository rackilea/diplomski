@Configuration
@ComponentScan(basePackages = {"<Your Package Name>"})
public class AppConfig {
 @Bean
 public FactoryBean serviceLocatorFactoryBean() {
    ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
    factoryBean.setServiceLocatorInterface(ParserFactory.class);
    return factoryBean;
 }

 @Bean(name = "jsonParser")
 @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
 public JsonParser jsonParser() {
    return new JsonParser();
 }

 @Bean(name = "xmlParser")
 @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
 public XMLParser xmlParser() {
    return new XMLParser();
 }
}