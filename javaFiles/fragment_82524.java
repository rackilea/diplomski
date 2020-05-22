JsonObjectRequest jsObjRequest = new JsonObjectRequest
        (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

    @Override
    public void onResponse(JSONObject response) {
        JSONArray arr = response.getJSONArray("Sales_Report");
        // now you have the array. in this array you have the jsonObjects
        // iterate on this array using a for loop and parse like you did before
    }
}, new Response.ErrorListener() {

    @Override
    public void onErrorResponse(VolleyError error) {
        // TODO Auto-generated method stub

    }
});