public class MapConstraints {

    @JsonDeserialize(using = CustomDeserializer.class)
    private Double zoomLatitude;

    @JsonDeserialize(using = CustomDeserializer.class)
    private Double zoomLongitude;
}