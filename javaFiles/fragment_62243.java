@Component
public class PortSetter {


    private final int port;

    @Autowired
    public PortConfiguration(NodeInformation nodeInformation) {
        this.port = nodeInformation.getPort();
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            container.setPort(port);
        });
    }
}