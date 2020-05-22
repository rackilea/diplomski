String insertUrl = "http://localhost/file.php";
String lastInsertId;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

    StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            lastInsertId = response.toString();
            System.out.println(lastInsertId); // returns the lastInsertId
            callback.onSuccess(lastInsertId);
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    }) {

        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> parameters = new HashMap<String, String>();

            // parameters

            return parameters;
        }
    };
    requestQueue.add(request);
}

public interface VolleyCallback{
    void onSuccess(ArrayList<Data> dataArrayList);
}