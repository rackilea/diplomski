JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, (JSONObject) null,
        new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONObject ratesJsonObj = response.getJSONObject("rates");
                    String RON = ratesJsonObj.getString("RON");

                    Log.v("Currency", RON);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {

    }
});