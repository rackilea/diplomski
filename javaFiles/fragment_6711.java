public void createCall(int type, String url, JSONObject data, final int callback) {
    JsonObjectRequest jsonRequest = new JsonObjectRequest(type, url,data,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    Log.d("Response", response.toString());
                    try {
                        callback(response, callback);
                    } catch (Exception e){
                        Log.d("API callback error", e.getMessage());
                    }

                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("Error response", error.toString());
                }
            }
    );
    queue.add(jsonRequest);
}