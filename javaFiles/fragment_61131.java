@Configuration
public class RabbitMQConfig {

    @Autowired
    private RabbitProperties rabbitProperties;

    @Autowired
    private CachingConnectionFactory cachingConnectionFactory;

    @PostConstruct
    public void init() {
        if ( rabbitProperties.getSsl().isEnabled() && rabbitProperties.getSsl().getKeyStore() != null ) {
            cachingConnectionFactory.getRabbitConnectionFactory().setSaslConfig( DefaultSaslConfig.EXTERNAL );
        }
    }

}