@Configuration
@PropertySource("file:${my.config}")
@ComponentScan(basePackages = {
        "com.my.filter", "com.my.controller"
        , "com.my.registration"
})

@EnableTransactionManagement(mode = AdviceMode.PROXY, proxyTargetClass = false)
@Import({MySecurityConfigurer.class, MyWebConfigurer.class})
public class DmRoot
{
    private final Environment env;

    @Autowired
    public MyRoot(Environment env)
    {
        Assert.notNull(env, "die Umgebungseinstellungen sind NULL");
        this.env = env;
        dbUserModelPackage = env.getProperty("my.userDbModel");
        dbAccountingModelPackage = env.getProperty("my.accountingDbModel");
    }

   // all my Spring beans
}