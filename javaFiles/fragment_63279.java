import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.PlacesApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.PlaceDetails;

public class Maps {

private static String apiKey;

public Maps(String apikey) {
    this.apiKey = apikey;
}

public String getTimezone(String address) throws Exception {

// The API will save the most matching result of your defined address in an array
GeocodingResult[] results = GeocodingApi.geocode(context, address).await();

 // .geometry.location returns an LatLng object coressponding to your address; 
//getTimeZone returns the timezone and it will be saved as a TimeZone object 
    TimeZone timeZone = TimeZoneApi.getTimeZone(context,results[0].geometry.location).await();

// returns the displayname of the timezone
    return timeZone.getDisplayName();

    }

}

public class Run {
public static void main(String[] args) throws Exception {

    String apiKey = "YOURGOOGLEAPIKEY"

    Maps m = new Maps(apiKey);
    m.getTimezone("Amsterdam");

    }
}