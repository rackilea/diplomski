@Parcel
@Root(name="point")
@Order(attributes={"lat", "lon", " alt"})
public class SensorLocation {
    @Attribute
    private double lat;

    @Attribute
    private double lon;

    @Attribute
    private double alt;

    @ParcelConstructor
    public SensorLocation (
        @Attribute(name="lat") double lat,
        @Attribute(name="lon") double lon,
        @Attribute(name="alt") double alt
    ) {
        this.lat = lat;
        this.lon = lon;
        this.alt = alt;
    }
}