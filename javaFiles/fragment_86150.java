protected void getCategories(){
    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, categoriesURL, new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            try {
                JSONArray jsonArray = response.getJSONArray("categories");
                downloadedCategories = new ArrayList<>(); // try to add your instantiation of your arrayList here.
                for(int i=0;i<jsonArray.length();i++) {
                    downloadedCategories.add(jsonArray.getJSONObject(i).getString("name"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {

    }
});
//this block of code will prompt after your downloadedCategories finish storing your objects to your arrayList because if you put this in onCreate this wil call before your getCategories process not finish yet. So much better its much safer here.
    ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,downloadedCategories);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    categories.setAdapter(adapter);
    requestQueue.add(jsonObjectRequest);
}