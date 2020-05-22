/**
 * @author mlekshma
 *
 */
@Configuration
@EnableScheduling
@ComponentScan("com.***.***")
@EnableIgniteRepositories(basePackages={"com.***.***"})
@ImportResource("classpath:ignite-client-conf.xml")
@PropertySource("classpath:ignite-client.properties")
@EnableTransactionManagement
public class IgniteClientConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(IgniteClientConfig.class);

    public IgniteClientConfig() {
    }

    /**
     * @return
     */
    @Bean
    @DependsOn("igniteInstance")
    @Primary
    @Lazy
    public PlatformTransactionManager transactionManager() {
        final SpringTransactionManager springTransactionManager = new SpringTransactionManager() {

            private boolean isInitialized = false;

            @Override 
            public void afterPropertiesSet() throws Exception {
                if (isInitialized) {
                    if(((IgniteKernal) getResourceFactory()).context().gateway().getState() == GridKernalState.STOPPED) {
                        IgniteKernal igniteKernal = (IgniteKernal) Ignition.ignite(getIgniteInstanceName());
                        if(igniteKernal != null) {
                            setResourceFactory(igniteKernal);
                        }
                    }
                }
            }

            /**
             * @param event
             */
            @EventListener
            public void handleContextRefresh(final ContextRefreshedEvent event) throws Exception {
                LOGGER.info("Setting up tx support..");
                super.afterPropertiesSet();
                isInitialized = true;
            }
        };
        // Use default grid client instance created..
        springTransactionManager.setTransactionConcurrency(TransactionConcurrency.PESSIMISTIC);
        return springTransactionManager;
    }

}