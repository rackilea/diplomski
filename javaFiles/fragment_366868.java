private void registerSocialUser (final String name, final String email) {
RequestQueue queue = Volley.newRequestQueue(this);
String stopArchiveUrl = Config.REGISTER_SOCIAL_URL;
StringRequest stringRequest = new StringRequest(Request.Method.POST, stopArchiveUrl,
    new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.d("CREATION", "Social Media Account Added: " + name + " " + email);
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.d("ERROR", "Error adding Social Media Account");
        }
}){
        @Override
        protected Map<String, String> getParams() {
            Map<String, String> params = new HashMap<>();
            params.put("name",name); //name
            params.put("email",email); //email
            return params; //return the parameters
        }
    };
// Add the request to the RequestQueue.
queue.add(stringRequest);
Intent intent = new Intent(LoginActivity.this, MainActivity.class);
startActivity(intent);
finish();