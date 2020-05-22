try {
    JSONObject jsonObject = new JSONObject(jsonQuery);
    if (jsonObject != null){
        JSONArray restaurants = jsonObject.getJSONArray("restaurants");
        for (int i = 0; i < restaurants.length(); i++){
            JSONObject restaurant = restaurants.getJSONObject(i);
            JSONObject restaurantsJSONObject =restaurant.getJSONObject("restaurant");
            if(restaurantsJSONObject.has("name")) {
                String tempName = restaurantsJSONObject.getString("name");
                Log.d(TAG, "Restaurant name: " + tempName);
            }
        }
    }
} catch (JSONException e) {
    Log.d(TAG, "Exception catched: " + e);
    e.printStackTrace();
}