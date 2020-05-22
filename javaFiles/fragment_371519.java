String myImage = "{image:" + imageEncoded + "}"

    JSONObject obj = null;

    try {
        obj = new JSONObject(myImage);
    } catch (JSONException e1) {
        e1.printStackTrace();
    }

    JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST,url,obj,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {


                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

            )} {


           @Override
           public Map<String, String> getHeaders() throws AuthFailureError {
               HashMap<String, String> headers = new HashMap<String, String>();

                    headers.put("Accept", "application/json; charset=utf-8");
                    headers.put("Content-Type", "application/json; charset=utf-8");

               return headers;
           }


        };