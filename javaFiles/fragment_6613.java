public void doLogin(String url, String cred, Response<String>.Listener callback) {
    StringRequest request = new StringRequest(
        url, 
        Request.GET, 
        callback,
        new Response.ErrorListener() { ... }
    );

    addToRequestQueue(request); 
}