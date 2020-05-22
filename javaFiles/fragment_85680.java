@Configuration
@ComponentScan(basePackages= {"it.olgna.spring.pool"})
public class CommonPoolConfig {

    @Bean("clientPool")
    public GenericObjectPool<Client> clientPool(){
        GenericObjectPool<Client> result = new GenericObjectPool<Client>(new FreeSwitchEslClientFactory());
        //Pool config e.g. max pool dimension
        result.setMaxTotal(20);
        return result;
    }
}