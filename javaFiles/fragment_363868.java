@JsonPropertyOrder({"color", "parts"})
public static class Car {

    @JsonProperty("color")
    private String color;
    @JsonProperty("parts")
    private List<Part> parts;

    public Car() {
        this.parts = new ArrayList<>();
    }