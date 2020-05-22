public void makeRequest(Customobject obj){

 RequestQueue requestQueue = Volley.newRequestQueue(this);
    String modifiedUrl = MainActivity.URL + "XXXXX";
    StringRequest stringRequest = new StringRequest(Request.Method.POST, modifiedUrl, new Response.Listener<String>() {

        @Override
        public void onResponse(String response) {
            Log.v("Response", response);
            i++;
            if(i < listobjects.size()){
                // make a recursive function 
                makeRequest(listobjects.get(i));
            } else {
                // Completed
           }



        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.v("Error", error.toString());
        }
})};

requestQueue.add(stringRequest);

}