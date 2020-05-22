@Configuration
public class MyConfig{
    @Bean(destroyMethod="cleanup")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Inner inner(){
        return new Inner();
    }


    @Bean(destroyMethod="cleanup")
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Middle middle(){
        return new Middle(inner());
    }

    @Bean
    public Outer outer1(){
        return new Outer(middle());
    }


    @Bean
    public Outer outer2(){
        return new Outer(middle());
    }


    @Bean
    public Outer outer3(){
        return new Outer(middle());
    }
}