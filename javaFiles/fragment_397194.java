@Configuration
@ConditionalOnProperty(value = "simplebean.lazy.init", havingValue="true") 
@PropertySource({"classpath:simple.properties"})
public class LazySimpleConfiguration {


    @Bean
    @Lazy(true) 
    public SimpleBean getSimpleBean(){
       return  new SimpleBean();
    }

    public static class SimpleBean{
    };

}


@Configuration
@ConditionalOnProperty(value="simplebean.lazy.init", havingValue="false")
@PropertySource({"classpath:simple.properties"})
public class SimpleConfiguration {


    @Bean
    @Lazy(false)
    public SimpleBean getSimpleBean(){
       return  new SimpleBean();
    }

    public static class SimpleBean{
    };

}