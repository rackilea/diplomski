protected Object doInBackground(Object[] objects) {
        HttpClient client = new HttpClient();
        client.get(get_token, new HttpResponseCallback() {
            @Override 
            public void success(String responseBody) {

                runOnUiThread(new Runnable() {
                    @Override 
                    public void run() { 

                        llHolder.setVisibility(View.VISIBLE);

                    try {
                        JSONObject jObject = new JSONObject(responseBody);
                        String token = jObject.getString("token");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    } 
                }); 
            }