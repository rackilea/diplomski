@Component
@Getter
@Setter
@ToString
public class MasterConfig {

    @NotNull
    @JsonProperty( "traffic_mappings" )
    private List<TrafficMapping> trafficMappings;
}