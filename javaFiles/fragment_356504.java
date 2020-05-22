@Service
public class Attribute1Service {

    @Resource
    private BeanSession beanSession;

    public void setDefaultValue() {
        Configuration configuration = beanSession.getRootState();
        configuration.getAttribute1().setValue("VALUE 1");
    }

    @Bean
    @Scope(value = "runtime", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Attribute1 attribute1() {
        Configuration configuration = beanSession.getRootState();
        return configuration.getAttribute1();
    }

}