HashMap<String, String> params = new HashMap<>();
params.put("value","value" );
params.put("value", "value");
JSONObject par = new JSONObject(params);

JsonObjectRequest objectRequest = new JsonObjectRequest("url here", par,
        new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response) {
            Log.d(" response", response.toString());
            }},
            new Response.ErrorListener()
            {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                //handle error here

                }
            });


// Access the RequestQueue through your singleton class.
MyApplication.getInstance().addToRequestQueue(jsObjRequest);