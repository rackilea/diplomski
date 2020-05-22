RequestQueue queue = MyVolley.getRequestQueue();
                StringRequest myReq = new StringRequest(Method.GET, 
                                                        "http://www.google.com/",
                                                        createMyReqSuccessListener(),
                                                        createMyReqErrorListener());

queue.add(myReq);

}

private Response.Listener<String> createMyReqSuccessListener() {
        return new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


               //TODO

            }
        };
    }


    private Response.ErrorListener createMyReqErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                  //TODO
            }
        };
    }