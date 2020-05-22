private void setUserData(final String username) {

    StringRequest strReq = new StringRequest(
        Request.Method.POST,
        Server.GET_USERDATA_URL, 
        new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                test = "test = "+response;
                showToast();

            }
        }, 
        new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(LoginActivity.this, volleyError.getMessage().toString(), Toast.LENGTH_LONG).show();

        }
    })

    {

        @Override
        protected Map<String, String> getParams() {
            // Posting parameters to getData url
            Map<String, String> params = new HashMap<String, String>();
            params.put(Server.KEY_USERNAME, username);
            return params;
        }

    };
    //Creating a Request Queue
    RequestQueue requestQueue = Volley.newRequestQueue(this);
    //Adding request to the queue
    requestQueue.add(strReq);
}

private void showToast() {

    Toast.makeText(LoginActivity.this, test, Toast.LENGTH_SHORT).show();
}