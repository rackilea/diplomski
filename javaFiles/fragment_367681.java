//import android.R;
//import android.R.layout;    //comment or delete these lines
//import android.R.id;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

setContentView(R.layout.activity_main);  //changed main to activity_main
mapview = (MapView)findViewById(R.id.mapview);