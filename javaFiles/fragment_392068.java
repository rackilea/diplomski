@Configuration
public class MyServiceProxyConfiguration {

    @Bean
    public MyServiceClient getMyServiceClient () { 
        return MyServiceClient.getInstance(); //initiate MyServiceClient
    }

    @Bean(name = MyServiceProxy.BEAN_NAME)
    public MyServiceProxy getMyServiceProxy(MyServiceClient client) { 
         return new MyServiceProxyImpl(client);
    }
}