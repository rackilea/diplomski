String url = "http://localhost/inc/signUp.php";
StringRequest rqst = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
    @Override
    public void onResponse(String response) {
        //get my response in an Array
        try{
            JSONObject obj = new JSONObject(response);
        } catch (JSONExeption e) {
            e.printStackTrace();
        }
    }
}, new Response.ErrorListener() {
    @Override
    public void onErrorResponse(VolleyError error) {
    }
});