public void sendPOST(final Context context, String url, JSONObject data, final ResponseCallback callback)
    {
        RequestQueue req_q = Volley.newRequestQueue(context);
        JsonObjectRequest data_req = new JsonObjectRequest(Request.Method.POST, url, data, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {
                try
                {
                    String stat  = response.getString("Status");
                    callback.myResponseCallback(stat);
                }catch (Exception e){e.printStackTrace();}
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {

            }
        });
        req_q.add(data_req);

    }
}