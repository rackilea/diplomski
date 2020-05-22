class Sample {

  private Map<String,Object> map = new HashMap<>();
  @JsonAnyGetter
  public Map<String,Object> getMap() {
    return this.map;
  }
  public void setMap(Map<String, Object> map) {
    this.map = map;
  }
  @JsonAnySetter
  public void addValue(String key, Object value) {
    this.map.put(key, value);
  }
}