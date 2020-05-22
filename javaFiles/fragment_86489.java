public void onResponse(JSONObject response) {
    mJsonResponse = response; <--------------------------------
    Log.d(TAG, mJsonResponse.toString());
    JSONObject results = mJsonResponse.getJSONObject("Results"); // NullPointerException here
    JSONArray seriesArray = results.getJSONArray("series");

    JSONObject DataSeries1 = seriesArray.getJSONObject(0);
    JSONArray DataArray1 = DataSeries.getJSONArray("data");

    JSONObject DataSeries2 = seriesArray.getJSONObject(1);
    JSONArray DataArray2 = DataSeries.getJSONArray("data");
}