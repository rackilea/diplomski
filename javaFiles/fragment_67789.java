@Configuration
public class HibernateConfig {

    @Bean(name = "myOtherBeanName")
    public A getMyA() {
        return new A();
    }

    @Bean
    public B getMyB() {
        // call me as usual - getMyA()
        return new B();
    }
}

class A {}
class B {}