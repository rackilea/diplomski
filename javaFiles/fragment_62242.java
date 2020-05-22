@Configuration
public class NodeInformationConfiguration {

    private final int port;
    private final int id;

    public NodeInformationConfiguration(@Value("${node.port}") int port, @Value("${node.id}") int id) {
        this.port = port;
        this.id = id;
    }

    @Bean
    public NodeInformation getNodeInfo() {
        return new NodeInformation(port, id);
    }
}