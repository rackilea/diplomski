public class Units {
  @JsonProperty("user_name")
  public String user_name;

  @JsonProperty("status")
  public List<Attr> attrs;

  ..
}
public class Attr {
  @JsonProperty("hp") 
  public String hp;
  @JsonProperty("karma") 
  public String karma;
  @JsonProperty("mp") 
  public String mp;
}

ObjectMapper mapr = new ObjectMapper();
Units unit = mapr.readValue(jsonString, Units.class);