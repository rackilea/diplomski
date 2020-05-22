Earthquake:

    public class Earthquake {

    private final String obsname;
    private final float magnitude;

    public Earthquake(String obsname, float magnitude) {
        this.obsname = obsname;
        this.magnitude = magnitude;
    }

    public float getMagnitude() {
        return magnitude;
    }

    public String getObsname() {
        return obsname;
    }
}