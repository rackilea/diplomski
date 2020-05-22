boolean initialIsGood = true;
MyResponseListener listener = new MyResponseListener(initialIsGood);
JsonObjectRequest getIdRequest = new JsonObjectRequest(Request.Method.GET, URL_ID, null, listener,   
 Response.ErrorListener { error ->
        // TODO: Handle error
    });
//outside of the listener, assuming that the status of the boolean changed and you want to find out the new value
boolean newValue = listener.isGoodParam();