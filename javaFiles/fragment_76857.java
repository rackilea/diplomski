public static void getServerData(final Context cntx) {
            myNotificationDb = new Notification_Db(cntx);
            RequestQueue queue = Volley.newRequestQueue(cntx);

            HttpsTrustManager.allowAllSSL();

            JsonObjectRequest jsObjRequest = new JsonObjectRequest(
                    Request.Method.GET, "Url", null,
                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {

                             // Your response

                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO Auto-generated method stub

                        }

                    }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {

                    // Your header parameter if you have otherwise this is optional

                    return headers;
                }
            };



queue.add(jsObjRequest);
    }