public class Mountain {
    private final String name;
    private final double latitude, longitude;
    private String country;

    public Mountain(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return this.name;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        //...
    }

    @Override
    public int hashCode() {
        //...
    }

    @Override
    public boolean equals(Object o) {
        //...
    }
}