private Handler handler;
private Runnable runnable;


public int onStartCommand(Intent intent, int flags, int startId) {
      handler = new Handler();
        if (runnable != null) {
            runnable = null;
        }
        runnable = new Runnable() {
            @Override
            public void run() {
                // do your stuff here, called every 3 second
                mQueue = Volley.newRequestQueue(getApplicationContext());

      //FROM NOW ON I WANT IT TO LOOP CONSTANTLY
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, API.getDeviceTypes(), null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    try {
                        processResponse(response);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("mytag", "Error de response");
                    error.printStackTrace();
                }
            });

            mQueue.add(request);
                h.postDelayed(this, 3000);
            }
        };

// start it with:
handler.post(runnable);

 return START_STICKY;


}