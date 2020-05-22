private Location location;
...

@JsonProperty("stream")
public void setStream(Map<String, Object> nested) {
    Map<String, Object> loc = nested.get("_doc").get("location");
    this.location = new Location();
    this.location.setCity(loc.get("city"));
    ....
}