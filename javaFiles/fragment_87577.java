private GoogleMap mMap;

JSONArray contentJson;

String contentId;
String imageJsonUrl;
String userId;
Bitmap bmp;
LatLng latLng;
Marker m;
HashMap<Marker, String> hashMap;

int k = 0;

// check value for Request check
final int MY_LOCATION_REQUEST_CODE = 3;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_maps);
    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
            .findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);
    Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
    setSupportActionBar(myToolbar);

    getSupportActionBar().setDisplayShowTitleEnabled(false);

    if(this.getIntent().getExtras() != null) {
            try {
                contentJson = new JSONArray(this.getIntent().getStringExtra("contentJson"));
               // Log.v("TESTITEST", contentJson.toString());
            } catch (JSONException e) {
                Log.e("EXCEPTION", "unexpected JSON exception", e);
                e.printStackTrace();
            }
    }
}

public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_maps, menu);
    return true;
}

public LatLng getLatLngPosition() {
    return new LatLng(0, 0);
}

/**
 * Manipulates the map once available.
 * This callback is triggered when the map is ready to be used.
 * This is where we can add markers or lines, add listeners or move the camera. In this case,
 * we just add a marker near Sydney, Australia.
 * If Google Play services is not installed on the device, the user will be prompted to install
 * it inside the SupportMapFragment. This method will only be triggered once the user has
 * installed Google Play services and returned to the app.
 */
@Override
public void onMapReady(GoogleMap googleMap) {

    mMap = googleMap;

    //Ask for Permission. If granted show my Location
    if (ActivityCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
        // Check Permissions Now
        ActivityCompat.requestPermissions(MapsActivity.this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                MY_LOCATION_REQUEST_CODE);
    } else {
        // permission has been granted, continue as usual
        mMap.setMyLocationEnabled(true);
    }

    PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
            getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

    autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
        @Override
        public void onPlaceSelected(Place place) {

            // TODO: Get info about the selected place.
            LatLng selectedLocation = place.getLatLng();
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(selectedLocation, 10f));
        }

        @Override
        public void onError(Status status) {
            // TODO: Handle the error.
            Log.i("PlaceSelectorError", "An error occurred: " + status);
        }
    });

    LatLng bonn = new LatLng(50.7323, 7.1847);
    LatLng cologne = new LatLng(50.9333333, 6.95);
    //mMap.addMarker(new MarkerOptions().position(bonn).title("Marker in Bonn"));

    // hash map for saving content id with marker
    hashMap = new HashMap<Marker, String>();

    if(contentJson != null) {

        if (this.getIntent().getStringExtra("contentId") == null) {
            // show all contents of my friends
            try {
                for (int i = 0; i < contentJson.length(); i++) {
                    JSONObject jsonInfo = contentJson.getJSONObject(i);

                    JSONArray contents = jsonInfo.getJSONArray("content");
                    // Log.v("contentslength", String.valueOf(contents.length()));

                    //get all contents of one user
                    for (int j = 0; j < contents.length(); j++) {
                        JSONObject eachcontent = contents.getJSONObject(j);
                        //Log.v("eachcontent", eachcontent.toString());
                        JSONObject location = eachcontent.getJSONObject("Location");
                        String contentId = eachcontent.getString("id");
                        String contentTitle = eachcontent.getString("title");
                        userId = eachcontent.getString("user_id");
                        latLng = new LatLng(Double.valueOf(location.getString("latitude")), Double.valueOf(location.getString("longitude")));
                        new MapImageLoadTask("http://192.168.63.35:1234/rest_app_users/getImage/", userId, contentId, contentTitle, latLng).execute();


                        Log.v("contentTitle", contentTitle);
                        //Log.v("m", m.toString());
                        //m = mMap.addMarker(new MarkerOptions().title(contentTitle).position(new LatLng(Double.valueOf(location.getString("latitude")), Double.valueOf(location.getString("longitude")))).icon(BitmapDescriptorFactory.fromBitmap(bmp)));
                    }
                }
            } catch (JSONException e) {
                Log.e("Exception", "unexpected JSON exception", e);
                e.printStackTrace();
            }
        }


        else {
            // if we only want to see a specific content
            try {
                List<RequestData> datas = new ArrayList<RequestData>();
                for (int i = 0; i < contentJson.length(); i++) {
                    JSONObject jsonInfo = contentJson.getJSONObject(i);

                    JSONArray contents = jsonInfo.getJSONArray("content");

                    //get all contents of one user


                    for (int j = 0; j < contents.length(); j++) {
                        JSONObject eachcontent = contents.getJSONObject(j);
                        JSONObject location = eachcontent.getJSONObject("Location");
                        if(eachcontent.getString("id").equals(this.getIntent().getStringExtra("contentId"))) {

                            String contentId = eachcontent.getString("id");
                            String contentTitle = eachcontent.getString("title");
                            userId = eachcontent.getString("user_id");
                            latLng = new LatLng(Double.valueOf(location.getString("latitude")), Double.valueOf(location.getString("longitude")));
                          //  Log.v("LATLNG", contentId);


                              RequestData data = new RequestData();
                              data.url = "http://192.168.63.35:1234/rest_app_users/getImage/";
                              data.userId = userId;
                              data.contentId = contentId;
                              data.contentTitle = contentTitle;
                              data.latlng = latlng;
                              datas.add(data);
                            //new MapImageLoadTask("http://192.168.63.35:1234/rest_app_users/getImage/", userId, contentId, contentTitle, latLng).execute();

                            continue;

                        }
                    }
                }

                new MapImageLoadTask(datas).execute();

            } catch (JSONException e) {
                Log.e("LOGEDILOG", "unexpected JSON exception", e);
                e.printStackTrace();
            }
        }
    }

    mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
        @Override
        public void onMyLocationChange(Location location) {
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng(location.getLatitude(), location.getLongitude()), 10f));
            mMap.setOnMyLocationChangeListener(null);
        }
    });

    mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
        @Override
        public void onInfoWindowClick(Marker marker) {
            String id = hashMap.get(marker);
            Log.v("BITMAP", bmp.toString());
            try {
                Context context = getApplicationContext();
                Intent mapIntent = new Intent(getApplicationContext(), contentDetailActivity.class);
                mapIntent.putExtra("contentId", id);
                mapIntent.putExtra("contentJson", contentJson.toString());
                mapIntent.putExtra("userId", userId);
                String filename = "profileImage.png";
                FileOutputStream stream = context.openFileOutput(filename, Context.MODE_PRIVATE);
                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);

                //Cleanup
                stream.close();
                mapIntent.putExtra("image", filename);

                startActivity(mapIntent);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

public Marker[] addMarkers() {
    return null;
}

/**
 *  lets you load Image from external source via url
 */

static class RequestData{

   public String url;
   public String userId;
   public String contentId;
   public String contentTitle;
   public LatLng latLng;
   public Bitmap bmp;
}


public class MapImageLoadTask extends AsyncTask<Void, RequestData, Void> {
    private final String LOG_TAG = MapImageLoadTask.class.getSimpleName();
    BufferedReader reader = null;


   List<RequestData> dataSet;

    public MapImageLoadTask(List<RequestData> dataSet) {
        this.dataSet = dataSet;
    }

    private String getImageUrlFromJson(String imageJson) throws JSONException {

        JSONObject imageJsonOutput = new JSONObject(imageJson);
        imageJsonUrl = imageJsonOutput.getString("imageUrl");
        //Log.v(LOG_TAG, imageJsonUrl);
        return imageJsonUrl;
    }

    @Override
    protected Bitmap doInBackground(Void... params) {

        for(RequestData item : dataSet){
            String imageJson = null;
              try {
                  URL urlConnection = new URL(url + userId);
                  HttpURLConnection connection = (HttpURLConnection) urlConnection
                          .openConnection();
                  connection.setDoInput(true);
                  connection.connect();
                  InputStream input = connection.getInputStream();
                  StringBuffer buffer = new StringBuffer();
                  if (input == null) {
                      // Nothing to do.
                      //forecastJsonStr = null;
                      return null;
                  }

                  reader = new BufferedReader(new InputStreamReader(input));

                  String line;
                  while ((line = reader.readLine()) != null) {
                      // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                      // But it does make debugging a *lot* easier if you print out the completed
                      // buffer for debugging.
                      buffer.append(line + "\n");
                  }

                  if (buffer.length() == 0) {
                      return null;
                  }

                  imageJson = buffer.toString();

              } catch (Exception e) {
                  e.printStackTrace();
              }


              try {
                  String jsonUrl = getImageUrlFromJson(imageJson);
                  URL url = new URL(jsonUrl);
                  bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                  // 
                  item.bmp = bmp;
                  publishProgress(item);
              }
              catch(Exception e) {
                  e.printStackTrace();
              }

         }



        return null;
    }

    protected void onPublishProgress(RequestData item){
        k +=1;
        Log.v("COUNTER", String.valueOf(k));
        m = mMap.addMarker(new MarkerOptions().title(item.title).position(item.location).icon(BitmapDescriptorFactory.fromBitmap(item.bmp)));
        hashMap.put(m, contentId);
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        super.onPostExecute(result);


    }
}
}