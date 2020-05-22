public interface AMixIn {
    // Filter for A (implemented to filter second depth as well)
    @JsonIgnore
    String getA2();

    @JsonUnwrapped
    public BMixIn getB();
}