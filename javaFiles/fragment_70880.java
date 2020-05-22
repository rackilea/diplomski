@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class NetworkStatistics {

    private String apiVersion;
    private String latitude;
    private String longitude;
    private String distance;
    @JsonProperty("network_type")
    private String networkType;
    private int perMinuteCurrent;
    private int perMinuteLimit;
    private int perMonthCurrent;
    private int perMonthLimit;
    private Object networkRank;

    public NetworkStatistics() {
    }

    // getters
}