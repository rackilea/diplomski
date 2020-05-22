@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "simulator.geo",ignoreUnknownFields = false)
public class VendorSimulatorProperties {

    private String host = "http://localhost:8080/";
    private String b12;
    private String b13;
    private String b21;
    private String c6;

}