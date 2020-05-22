final Response.Listener<String> responseListener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.d("RESPONSE", String.valueOf(response));
        }
    };

final Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

            //Handle your errors
        }
    };

StringRequest request = new StringRequest(Request.Method.POST, url,
            responseListener, errorListener) {
        @Override
        protected Map<String, String> getParams() {
            Map<String, String> params = new HashMap<>();
            //Put your params for post
            return params;
        }

        @Override
        public Map<String, String> getHeaders() {
            Map<String,String> params = new HashMap<>();
            params.put("Content-Type","application/x-www-form-urlencoded"); //-> this is the key
            return params;
        }
    };