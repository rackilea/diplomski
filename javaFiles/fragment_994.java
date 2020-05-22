StringBuilder finalURL = new StringBuilder("https://");
finalURL.append(credentials.getUrl());
finalURL.append("/s1services");
String url = finalURL.toString();

JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

    @Override
    public void onResponse(JSONObject response) {
        //handle your json response here
        us = gson.fromJson(String.valueOf(response), UserData.class);
    }
  }, new Response.ErrorListener() {

  @Override
  public void onErrorResponse(VolleyError error) {
      // TODO: Handle error

  }
});

// Access the RequestQueue through your singleton class.
MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);