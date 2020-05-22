@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass=false)
@ComponentScan(value={"my.package.path.config", "my.package.path.web"})
public class WebConfig {

    @Bean
    public TestAOP testAop() throws Exception {
        return new TestAOP();
    }

    @Bean
    public TestAOPClient testAopClient() throws Exception {
        return new TestAOPClient();
    }

}