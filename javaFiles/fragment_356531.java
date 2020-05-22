@Configuration
@ComponentScan(basePackages = {"mycompany.imageviewer.controller", "mycompany.imageviewer.dataprovider.impl" })
public class SpringApplicationConfig {
    private static final Logger LOG = Logger.getLogger(SpringApplicationConfig.class);

    @Bean
    public DataProvider dataProvider() {
        LOG.debug("Initializing dataProvider via SpringApplicationConfig");
        return new DataProviderImpl();
    }

    @Bean
    @Scope("prototype")
    public ImageViewerController imageViewerController() {
        LOG.debug("Initializing ImageViewerController via SpringApplicationConfig");
        return new ImageViewerController();
    }
}