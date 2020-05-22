@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TravelpayoutsResponse {
    private boolean success;
    private Map<String, Map<String, FlightDetail> data;
    private String error;
    private String currency;
}

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightDetail {
    private int price;
    private String airline;
    @JsonProperty("flight_number")
    private String flightNumber;
    @JsonProperty("departure_at")
    private String departureDate;
    @JsonProperty("return_at")
    private String returnDate;
    @JsonProperty("expires_at")
    private String expirationDate;
}