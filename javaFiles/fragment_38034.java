while (iter.hasNext()) {
    String key = iter.next();
    try {
        JSONObject bike = Bikes.getJSONObject(key);
        Log.v("Bike", bike.toString());
        int id = bike.getInt("id");
    } catch(JSONException e) {}

}