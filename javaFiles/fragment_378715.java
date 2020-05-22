AsyncGeocoderObject.java // object to pass to asynctask

public class AsyncGeocoderObject {

    public Location location; // location to get address from
    Geocoder geocoder; // the geocoder
    TextView textView; // textview to update text

    public AsyncGeocoderObject(Geocoder geocoder, Location location, TextView textView) {
        this.geocoder = geocoder;
        this.location = location;
        this.textView = textView;
    }
}