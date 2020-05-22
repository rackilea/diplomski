// in onCreate()
new AsyncGeocoder().execute(new AsyncGeocoderObject(
        new Geocoder(this), // the geocoder object to get address
        location, // location object, 
        locationTV // the textview to set address on
));