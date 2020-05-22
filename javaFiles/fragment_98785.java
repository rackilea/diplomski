public  void getMarkers(final VolleyCallBack callBack){

requestQueue = Volley.newRequestQueue(getApplicationContext());
JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, new Response.Listener<JSONObject>() {


    @Override
    public void onResponse(JSONObject response) {

        try {

            JSONArray saagTracker = response.getJSONArray("saagMRK");
            for (int i = 0; i < saagTracker.length(); i++) {
                JSONObject object = saagTracker.getJSONObject(i);

                title = object.getString(TITLE);
                snnipet = object.getString(SNNIP);
                latLng = new LatLng(Double.parseDouble(object.getString(LAT)), Double.parseDouble(object.getString(LNG)));
                coor = coor + "|" + object.getString(LAT) + "," + object.getString(LNG);                        // Menambah data marker untuk di tampilkan ke google map

                addMarker(latLng, title, snnipet);

                callback.onSuccess();

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        //JSONArray array = new JSONArray(response.body().string());

    }
}, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(MainActivity.this, "Ocurrio un error", Toast.LENGTH_LONG).show();
    }
});
requestQueue.add(jsonObjectRequest);
}