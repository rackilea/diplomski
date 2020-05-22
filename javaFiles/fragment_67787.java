@Configuration
public class HibernateConfig {

    @Bean
    public A getMyA() {
        return new A();
    }

    @Bean
    @Autowired
    public B getMyB(A a) {
        System.out.println(a != null);
        return new B();
    }
}

class A {}
class B {}