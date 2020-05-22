HashMap<String, String> params = new HashMap<String, String>();
    params.put("customer_name", "ass");
    params.put("hotel_id", "6");
    params.put("mobile_no", "999966632");

String YourURL = "http://......com/hotel/api/customerapi/customer_register?APIKEY=9ffeb408h93053dc0e59a0c3f8814bcb8df30b69";

JsonObjectRequest request_json = new JsonObjectRequest(YourURL, new JSONObject(params)),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //Do what you want on response 
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //If there's an error...
            }
        });

        //Add process to queue to get JSON in background thread
        queue.add(request_json);