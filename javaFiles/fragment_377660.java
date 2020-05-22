private void makeStringReq(String url, int method)
    {
        showProgressDialog();

        // Instantiate the Request Q
        RequestQueue q = Volley.newRequestQueue(this);

        StringRequest strReq = new StringRequest(method, url, new Response.Listener<String>()
            {

                @Override
                public void onResponse(String response)
                    {

                        Log.d(TAG, response.toString());
                        msgResponse.setText(response.toString());
                        hideProgressDialog();
                        makeStringReq(URL_B,Method.POST);
                    }
            }, new Response.ErrorListener()
            {
                @Override
                public void onErrorResponse(VolleyError error)
                    {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                        hideProgressDialog();
                    }
            });
        // Add the request to the RequestQueue.
        q.add(strReq);
    }