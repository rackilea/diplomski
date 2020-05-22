RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext());
JsonObjectRequest request = new JsonObjectRequest(Method.GET, cityListUrl, null, new
    Listener<JSONObject>() {
        public void onResponse(JSONObject jsonResults) {
            //Any Call
        }
    }, new ErrorListener(){
        public void onErrorResponse(VolleyError arg0) {
            //Any Error log
        }
    }
);


int socketTimeout = 30000;//30 seconds - change to what you want
RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
request.setRetryPolicy(policy);
mRequestQueue.add(request);