String uri = "www.google.com" + params;

RequestQueue queue = MyVolley.getRequestQueue();
                    StringRequest myReq = new StringRequest(Method.GET, 
                                                            uri,
                                                            createMyReqSuccessListener(),
                                                            createMyReqErrorListener());

    queue.add(myReq);

    }