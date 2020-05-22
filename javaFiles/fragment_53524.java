//Creating a json object request
JsonObjectRequest jsonObjectRequest = new JsonObjectRequest (Config.DATA_URL,
        new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //Dismissing progress dialog
                Toast.makeText(MainActivity.this, "sachin", Toast.LENGTH_SHORT).show();
                loading.dismiss();

                // College 
                JSONArray jsonArrayCollege = response.getJSONArray("College");

                // calling method to parse json array
                parseData(jsonArrayCollege);
            }
        },
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

//Creating request queue
RequestQueue requestQueue = Volley.newRequestQueue(this);

//Adding request to the queue
requestQueue.add(jsonObjectRequest);