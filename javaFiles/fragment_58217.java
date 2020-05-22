public class MainActivity extends FragmentActivity implements OnClickListener {

    private GoogleMap myMap;
    Polyline line;
    Context context;

    Location location;
    boolean check_provider_enabled = false;

    // Static LatLng
    LatLng startLatLng = new LatLng(30.707104, 76.690749);
    LatLng endLatLng = new LatLng(30.721419, 76.730017);

    public void onCreate(Bundle bd) {
        super.onCreate(bd);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;



        // GoogleMap myMap
        myMap = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map)).getMap();

        /*
        // Construct a CameraPosition focusing on Mountain View and animate the camera to that position.
        CameraPosition cameraPosition = new CameraPosition.Builder()
            //.target(endLatLng)      // Sets the center of the map to Mountain View
            .zoom(17)                   // Sets the zoom
            .bearing(90)                // Sets the orientation of the camera to east
            .tilt(30)                   // Sets the tilt of the camera to 30 degrees
            .build();                   // Creates a CameraPosition from the builder
        myMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));*/

        myMap.setMyLocationEnabled(true);
        myMap.moveCamera(CameraUpdateFactory.newLatLng(startLatLng));
        myMap.animateCamera(CameraUpdateFactory.zoomTo(12));

        myMap.getUiSettings().setZoomControlsEnabled(false);







        LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
        boolean enabled = service.isProviderEnabled(LocationManager.GPS_PROVIDER);
        location = service.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        // check if enabled and if not send user to the GSP settings
        // Better solution would be to display a dialog and suggesting to 
        // go to the settings
        if (!enabled) {
          /*Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
          startActivity(intent);*/
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Enable GPS servcies to use this app.", Toast.LENGTH_LONG).show();
        } else{



            try{

                final LatLng PERTH = new LatLng(-31.90, 115.86);
                Marker perth = myMap.addMarker(new MarkerOptions()
                                          .position(PERTH)
                                          .anchor((float)0.5,(float)0.5)
                                          .rotation((float)90.0));

                String urlTopass = makeURL(startLatLng.latitude,
                        startLatLng.longitude, endLatLng.latitude,
                        endLatLng.longitude);
               // new connectAsyncTask(urlTopass).execute();

            }catch(Exception e){
                e.printStackTrace();
            }

        }

       /* if (myMap!=null){
            Marker hamburg = myMap.addMarker(new MarkerOptions().position(startLatLng)
                .title("Hamburg"));
            Marker kiel = myMap.addMarker(new MarkerOptions()
                .position(endLatLng)
                .title("Vivek")
                .snippet("VIVEK's ANDROID HACKER")
                .icon(BitmapDescriptorFactory
                    .fromResource(R.drawable.one)));
          }*/



        // Now auto clicking the button
       // btntemp.performClick();
    }
/*
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
        case R.id.btn_pass_home_call_temp:
            String urlTopass = makeURL(startLatLng.latitude,
                    startLatLng.longitude, endLatLng.latitude,
                    endLatLng.longitude);
            new connectAsyncTask(urlTopass).execute();
            break;

        default:
            break;
        }

    }*/

    private class connectAsyncTask extends AsyncTask<Void, Void, String> {
        private ProgressDialog progressDialog;
        String url;

        connectAsyncTask(String urlPass) {
            url = urlPass;
        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage("Fetching route, Please wait...");
            progressDialog.setIndeterminate(true);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(Void... params) {
            JSONParser jParser = new JSONParser();
            String json = jParser.getJSONFromUrl(url);
            return json;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            progressDialog.hide();
            if (result != null) {
                drawPath(result);
            }
        }
    }

    public String makeURL(double sourcelat, double sourcelog, double destlat,
            double destlog) {
        StringBuilder urlString = new StringBuilder();
        urlString.append("http://maps.googleapis.com/maps/api/directions/json");
        urlString.append("?origin=");// from
        urlString.append(Double.toString(sourcelat));
        urlString.append(",");
        urlString.append(Double.toString(sourcelog));
        urlString.append("&destination=");// to
        urlString.append(Double.toString(destlat));
        urlString.append(",");
        urlString.append(Double.toString(destlog));
        urlString.append("&sensor=false&mode=driving&alternatives=true");
        return urlString.toString();
    }

    public class JSONParser {

        InputStream is = null;
        JSONObject jObj = null;
        String json = "";

        // constructor
        public JSONParser() {
        }

        public String getJSONFromUrl(String url) {

            // Making HTTP request
            try {
                // defaultHttpClient
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(url);

                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(is, "iso-8859-1"), 8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }

                json = sb.toString();
                is.close();
            } catch (Exception e) {
                Log.e("Buffer Error", "Error converting result " + e.toString());
            }
            return json;

        }
    }

    public void drawPath(String result) {
        if (line != null) {
            myMap.clear();
        }
        myMap.addMarker(new MarkerOptions().position(endLatLng).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
        myMap.addMarker(new MarkerOptions().position(startLatLng).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
        try {
            // Tranform the string into a json object
            final JSONObject json = new JSONObject(result);
            JSONArray routeArray = json.getJSONArray("routes");
            JSONObject routes = routeArray.getJSONObject(0);
            JSONObject overviewPolylines = routes
                    .getJSONObject("overview_polyline");
            String encodedString = overviewPolylines.getString("points");
            List<LatLng> list = decodePoly(encodedString);

            PolylineOptions options = new PolylineOptions().width(5).color(Color.BLUE).geodesic(true);
            for (int z = 0; z < list.size(); z++) {
                LatLng point = list.get(z);
                options.add(point);
            }
            line = myMap.addPolyline(options);

            /*for (int z = 0; z < list.size() - 1; z++) {
                LatLng src = list.get(z);
                LatLng dest = list.get(z + 1);
                line = myMap.addPolyline(new PolylineOptions()
                        .add(new LatLng(src.latitude, src.longitude),
                                new LatLng(dest.latitude, dest.longitude))
                        .width(5).color(Color.BLUE).geodesic(true));
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<LatLng> decodePoly(String encoded) {

        List<LatLng> poly = new ArrayList<LatLng>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            LatLng p = new LatLng((((double) lat / 1E5)),
                    (((double) lng / 1E5)));
            poly.add(p);
        }

        return poly;
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub

    }

    /*@Override
    public void onMarkerDrag(Marker marker) {

       //add the marker's latlng in a arraylist of LatLng and pass it to the loop
        for (int i = 0; i < arraylistoflatlng.size(); i++) {
             myMap.addPolyline(new PolylineOptions()
            .addAll(arraylistoflatlng)
            .width(5)
            .color(Color.RED));
        }
        }*/
}