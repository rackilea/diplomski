StringRequest jsonObjReq = new StringRequest(Request.Method.POST, url,
        new com.android.volley.Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response.toString());

                    // Parse your JSON data here. 

                } catch (JSONException e) {

                }
            }
        }, new com.android.volley.Response.ErrorListener() {

    @Override
    public void onErrorResponse(VolleyError error) {
        System.out.println("error:: " + error.toString());
    }
})

{
    @Override
    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    @Override
    protected Map<String, String> getParams() {
        Map<String, String> params = new HashMap<String, String>();
        params.put(KEY_SYS_ID, String.valueOf(sys_Id));
        return params;
    }
};