@Override
 public void onMapReady(GoogleMap googleMap) {
     mMap = googleMap;

     displayMarker();
 }


 private void loadLocation() {
     new FetchJSON().execute();
 }


 class FetchJSON extends AsyncTask<String, Integer, LatLng> {

     @Override
     protected LatLng doInBackground(String... params) {
         LatLng latLng = null;
         try {
             URL url = new URL("https://api.myjson.com/bins/ehzqu");
             HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
             InputStream inputStream = httpURLConnection.getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

             StringBuilder stringBuilder = new StringBuilder();
             String line = "";
             while ((line = bufferedReader.readLine()) != null) {
                 stringBuilder.append(line).append("\n");
             }
             bufferedReader.close();

             String json = stringBuilder.toString();

             Log.e(TAG, "Return = " + json);
             String lat= "";
             String lng= "";
             JSONObject obj = new JSONObject(json);
             JSONArray array = obj.getJSONArray("server response");
             for(int i = 0; i < array.length(); i++){
                 JSONObject o = array.getJSONObject(i);

                 lat = o.optString("lat");
                 lng = o.optString("lng");
             }

             Log.e(TAG, "Lat = " + lat);
             Log.e(TAG, "lng = " + lng);

             double latDouble = Double.parseDouble(lat);
             double lngDouble = Double.parseDouble(lng);

             latLng = new LatLng(latDouble, lngDouble);
         }
         catch (Exception ex) {
             Log.e(TAG, "doInBackground --- " + ex.getMessage());
         }
         return latLng;
     }


     @Override
     protected void onPostExecute(LatLng latLng) {
         try{
             if(latLng != null){
                 mLatLng = latLng;
                 displayMarker();
             }

         }
         catch(Exception ex){
             Log.e(TAG, "onPostExecute" + ex.getMessage());
         }
     }

 }

 private void displayMarker(){
     if(mMap == null) return;
     if(mLatLng == null) return;

     MarkerOptions markerOption = new MarkerOptions();
     markerOption.position(mLatLng);
     mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mLatLng, zoomFactor));
     mMap.addMarker(markerOption);
 }