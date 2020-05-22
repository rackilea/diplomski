@Component
public class DynamicSystemProperties implements ApplicationListener<EnvironmentChangeEvent>{

    private final Environment env;

    @Autowired
    public DynamicSystemProperties(Environment env) {
        this.env = env;

    }

    @Override
    public void onApplicationEvent(EnvironmentChangeEvent environmentChangeEvent) {

        if(env.containsProperty("system.javax.net.ssl.keyStore")) {
            String keystore = env.getProperty("system.javax.net.ssl.keyStore");
            System.out.println("system.javax.net.ssl.keyStore - " + keystore);

            System.getProperties().setProperty("javax.net.ssl.keyStore", keystore);
        }
    }
}