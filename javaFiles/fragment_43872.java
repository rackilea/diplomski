import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.annotations.PolylineOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.services.Constants;
import com.mapbox.services.android.geocoder.ui.GeocoderAutoCompleteView;
import com.mapbox.services.commons.ServicesException;
import com.mapbox.services.commons.geojson.LineString;
import com.mapbox.services.commons.models.Position;
import com.mapbox.services.directions.v5.DirectionsCriteria;
import com.mapbox.services.directions.v5.MapboxDirections;
import com.mapbox.services.directions.v5.models.DirectionsResponse;
import com.mapbox.services.directions.v5.models.DirectionsRoute;
import com.mapbox.services.geocoding.v5.GeocodingCriteria;
import com.mapbox.services.geocoding.v5.models.GeocodingFeature;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    private final static String TAG = "MainActivity";

    private MapView mapView;
    private MapboxMap map;
    private DirectionsRoute currentRoute;

    private Position origin;
    private Position destination;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup the MapView
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                map = mapboxMap;

                mapboxMap.setMyLocationEnabled(true);

                // Set up autocomplete widget
                GeocoderAutoCompleteView autocomplete = (GeocoderAutoCompleteView) findViewById(R.id.query);
            autocomplete.setAccessToken("<your access token>");
            autocomplete.setType(GeocodingCriteria.TYPE_POI);
            autocomplete.setOnFeatureListener(new GeocoderAutoCompleteView.OnFeatureListener() {
                @Override
                public void OnFeatureClick(GeocodingFeature feature) {

                    if(map.getMyLocation() != null) {
                        // Set the origin as user location only if we can get their location
                        origin = Position.fromCoordinates(map.getMyLocation().getLongitude(), map.getMyLocation().getLatitude());
                    }else{
                        return;
                    }

                    destination = feature.asPosition();

                    // Add origin and destination to the map
                    map.addMarker(new MarkerOptions()
                            .position(new LatLng(origin.getLatitude(), origin.getLongitude())));
                    map.addMarker(new MarkerOptions()
                            .position(new LatLng(destination.getLatitude(), destination.getLongitude())));

                    // Get route from API
                    try {
                        getRoute(origin, destination);
                    } catch (ServicesException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    });
}

private void getRoute(Position origin, Position destination) throws ServicesException {

    MapboxDirections client = new MapboxDirections.Builder()
            .setOrigin(origin)
            .setDestination(destination)
            .setProfile(DirectionsCriteria.PROFILE_CYCLING)
            .setAccessToken("<your access token>")
            .build();

    client.enqueueCall(new Callback<DirectionsResponse>() {
        @Override
        public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
            // You can get the generic HTTP info about the response
            Log.d(TAG, "Response code: " + response.code());
            if (response.body() == null) {
                Log.e(TAG, "No routes found, make sure you set the right user and access token.");
                return;
            }

            // Print some info about the route
            currentRoute = response.body().getRoutes().get(0);
            Log.d(TAG, "Distance: " + currentRoute.getDistance());
            Toast.makeText(MainActivity.this, "Route is " +  currentRoute.getDistance() + " meters long.", Toast.LENGTH_SHORT).show();

            // Draw the route on the map
            drawRoute(currentRoute);
        }

        @Override
        public void onFailure(Call<DirectionsResponse> call, Throwable t) {
            Log.e(TAG, "Error: " + t.getMessage());
            Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    });
}

private void drawRoute(DirectionsRoute route) {
    // Convert LineString coordinates into LatLng[]
    LineString lineString = LineString.fromPolyline(route.getGeometry(), Constants.OSRM_PRECISION_V5);
    List<Position> coordinates = lineString.getCoordinates();
    LatLng[] points = new LatLng[coordinates.size()];
    for (int i = 0; i < coordinates.size(); i++) {
        points[i] = new LatLng(
                coordinates.get(i).getLatitude(),
                coordinates.get(i).getLongitude());
    }

    // Draw Points on MapView
    map.addPolyline(new PolylineOptions()
            .add(points)
            .color(Color.parseColor("#009688"))
            .width(5));
}

@Override
public void onResume() {
    super.onResume();
    mapView.onResume();
}

@Override
public void onPause() {
    super.onPause();
    mapView.onPause();
}

@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    mapView.onSaveInstanceState(outState);
}

@Override
protected void onDestroy() {
    super.onDestroy();
    mapView.onDestroy();
}

@Override
public void onLowMemory() {
    super.onLowMemory();
    mapView.onLowMemory();
}