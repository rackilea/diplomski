public class PlacesDisplayTask extends AsyncTask<Object, Integer, List<HashMap<String, String>>> {

     ArrayList<NearbyPlaceModel> data_place = new ArrayList<>();   // change
     JSONObject googlePlacesJson;
     GoogleMap googleMap;
     PlaceInterface placeInterface;    // change

     public PlacesDisplayTask(PlaceInterface placeInterface){   // change
         this.placeInterface = placeInterface;
     }

     @Override
     protected List<HashMap<String, String>> doInBackground(Object... inputObj) {

         List<HashMap<String, String>> googlePlacesList = null;
         Places placeJsonParser = new Places();

         try {
             googleMap = (GoogleMap) inputObj[0];
             googlePlacesJson = new JSONObject((String) inputObj[1]);
             googlePlacesList = placeJsonParser.parse(googlePlacesJson);
         } catch (Exception e) {
             Log.d("Exception", e.toString());
         }
         return googlePlacesList;
     }

     @Override
     protected void onPostExecute(List<HashMap<String, String>> list) {
         googleMap.clear();
         data_place.clear();
         for (int i = 0; i < list.size(); i++) {
             if(i < 10 ) {
                 HashMap<String, String> googlePlace = list.get(i);
                 double lat = Double.parseDouble(googlePlace.get("lat"));
                 double lng = Double.parseDouble(googlePlace.get("lng"));
                 String placeName = googlePlace.get("place_name");
                 String vicinity = googlePlace.get("vicinity");
                 LatLng latLng = new LatLng(lat, lng);
             markerOptions.icon(BitmapDescriptorFactory.fromBitmap(Configure.getBitmapFromURL(googlePlace.get("icon"))));
                 markerOptions.title(placeName + " : " + vicinity);
                 googleMap.addMarker(markerOptions);

                 NearbyPlaceModel items = new NearbyPlaceModel();
                 items.setVicinity(vicinity);
                 items.setPlace_name(placeName);
                 items.setLat(String.valueOf(lat));
                 items.setLang(String.valueOf(lng));
                 data_place.add(items);

                 placeInterface.myPlaceList(data_place);  // change
             }
         }
     }

 }