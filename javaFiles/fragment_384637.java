public class City implements Comparable {
    private String name; // The name of the city
    private double latitude; // its latitude
    private double longitude; // its longitude

    public City(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return name + ": " + latitude + " - " + longitude;
    }

    @Override
    public int compareTo(Object c) {
        City city = (City) c;
        return name.compareTo(city.name);
    }
}