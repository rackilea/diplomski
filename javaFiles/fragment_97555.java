Boolean isRequestProcess = false;
mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {

 @Override
 public void onMapLongClick(final LatLng arg0) {
     if(isRequestProcess){
         return;
     }
    isRequestProcess = true;
     RequestQueue queue = Volley.newRequestQueue(getActivity());
                String url = "https://maps.googleapis.com/maps/api/geocode/json?latlng=" + String.valueOf(arg0.latitude) + "," + String.valueOf(arg0.longitude) + "&key=myKey";

     // Request a string response from the provided URL.
     StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
         @Override
         public void onResponse(String response) {
             try {
                 JSONArray jObj = new JSONObject(response).getJSONArray("results").getJSONObject(0).getJSONArray("address_components");

                 Intent intent = new Intent(getActivity(), AddRestaurantActivity.class);

                  for (int i = 0; i < jObj.length(); i++) {
                      String componentName = new JSONObject(jObj.getString(i)).getJSONArray("types").getString(0);
                      if (componentName.equals("postal_code") || componentName.equals("locality") || componentName.equals("street_number") || componentName.equals("route")
                                                || componentName.equals("neighborhood") || componentName.equals("sublocality") || componentName.equals("administrative_area_level_2")
                                                || componentName.equals("administrative_area_level_1") || componentName.equals("country")) {
                                            intent.putExtra(componentName, new JSONObject(jObj.getString(i)).getString("short_name"));
                       }
                  }

                   intent.putExtra("latitude", arg0.latitude);
                   intent.putExtra("longitude", arg0.longitude);

                   startActivity(intent);
                   isRequestProcess = false;

               } catch (JSONException e) {
                  e.printStackTrace();
              }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                int x = 1;
            }

        }
    }
}