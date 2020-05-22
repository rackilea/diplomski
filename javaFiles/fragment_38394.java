/**
 * Immutable point in geo coordinates (latitude, longitude) with accuracy in km
 */
public class GeoPoint {

    private final double lat;
    private final double lon;
    private final double accuracy;

    /**
     * New geo point without accuracy
     */
    public GeoPoint(double lat, double lon){
        this(lat, lon, -1d);
    }

    /**
     * New geo point with specified accuracy
     * @param accuracy  accuracy in km
     */
    public GeoPoint(double lat, double lon, double accuracy){
        this.lat = lat;
        this.lon = lon;
        this.accuracy = accuracy < 0 ? -1d : accuracy;
    }

    public double getLat(){
        return this.lat;
    }

    public double getLon(){
        return this.lon;
    }

    /**
     * @return accuracy in km. If < 0, accuracy is not defined
     */
    public double getAccuracy(){
        return this.accuracy;
    }

    @Override
    public String toString(){
        return "lat = " + this.lat + "; lon = " + this.lon + (this.accuracy < 0 ? "" : ("; accuracy = " + this.accuracy));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeoPoint) || o == null) return false;
        GeoPoint g = (GeoPoint) o;
        return g.lat == this.lat && g.lon == this.lon && g.accuracy == this.accuracy; 
    }


}