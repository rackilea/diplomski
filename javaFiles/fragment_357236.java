@EnableGlobalMethodSecurity (prePostEnabled = true, securedEnabled = true)
@Configuration
@ImportResource({"classpath:/conf/applicationContext-db.xml"})
public class AclMethodSecurityConfiguration extends GlobalMethodSecurityConfiguration implements BeanFactoryAware {

    DataSource dataSource;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.dataSource = beanFactory.getBean("dataSource", DataSource.class);
    }
    // rest of code goes here 
}