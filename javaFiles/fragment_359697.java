@Configuration
public class SpringConfig {
    @Bean(name="clazzImplA")
    public BaseInterface clazzImplA(){
        return new ClazzImplA();
    }

    @Bean(name="clazzImplB")
    public BaseInterface clazzImplB(){
        return new ClazzImplB();
    }
}