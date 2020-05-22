RequestQueue queue = VolleyService.getInstance(this.getContext()).getRequestQueue();
StringRequest request = new StringRequest(url, new Response.Listener<String>() {    
                @Override
                public void onResponse(String response) {
                    // we got the response, now our job is to handle it
                    try {
//Here you parse your JSON - best approach is to use GSON for deserialization
                        getJsonFromResponse(response);
                    } catch (RemoteException | OperationApplicationException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    //something happened, treat the error.
                    Log.e("Error", error.toString());
                }
            });

            queue.add(request);