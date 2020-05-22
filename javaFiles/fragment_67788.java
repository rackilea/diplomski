@Configuration
public class HibernateConfig {

    @Bean(name = "myOtherBeanName")
    public A getMyA() {
        return new A();
    }

    @Bean
    @Autowired
    public B getMyB(@Qualifier("myOtherBeanName") A a) {
        System.out.println(a != null);
        return new B();
    }
}

class A {}
class B {}