public class FlightDTO {
  @MongoObjectId
  private String id;

  private String departure;
  private String arrival;
  private String airline;
  private Double price;

  public FlightDTO() {
  }

  public FlightDTO(JSONObject data) {
    this.departure = data.getString("departure");
    this.arrival = data.getString("arrival");
    this.airline = data.getString("airline");
    this.price = data.getDouble("price");
  }

  public JSONObject toJson() {
    return new JSONObject()
            .put("id", this.id)
            .put("departure", this.departure)
            .put("arrival", this.arrival)
            .put("airline", this.airline)
            .put("price", this.price);
  }
}