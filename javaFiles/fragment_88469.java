@Getter
public class HoursResponse {
    private Long licenceNumber; // you can remove licenseNumber if not needed
    private TradingHours[] tradingHours;
    // add also this if needed later
    // private ShutdownHours shutdownHours;
}