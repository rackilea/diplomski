StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                        JSONArray array = new JSONArray(response);  //here is the mistake of parsing which will be removed after it is converted to the json object
                        JSONObject object = array.getJSONObject(0); //-----mistake
                        String frm = object.getString("src_num");
                        String msg = object.getString("msg");
                        int id = object.getInt("id");
                        itemsAdapter.add(frm + ": " + msg);
                        Log.d("Response", response.toString());
                        } catch (JSONException e) {
                           Log.d("excpetion", err.toString());
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
         Log.d("Error.response", err.toString());
            }
        });

        new RequestHandler().addToRequestQueue(stringRequest);