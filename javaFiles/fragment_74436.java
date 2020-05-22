public class VolleyAPIService {

    public VolleyCallback callback; 

    public void volleyPost(String URL, Map<String, String> param, Context context) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        final Map<String, String> params = param;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {;
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
}