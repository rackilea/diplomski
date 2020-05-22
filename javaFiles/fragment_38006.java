@JsonCreator(mode=Mode.DELEGATING)
public ClassContainingMap(@JsonProperty("map")Map<String,String> map) {
    this.map = map;
}

@JsonValue
public Map<String, String> getMap() {
    return map;
}