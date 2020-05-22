public class VolleyTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_test);
    }

    public void makeRequest(View v) {
        Log.i(getLocalClassName(), "Request");

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.start();
        queue.add(new JsonObjectRequest(Request.Method.GET, Urls.STATIC_URL + "/profiles.json", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i(getLocalClassName(), "Response");
                Log.i(getLocalClassName(), "Done");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(getLocalClassName(), "Error");
            }
        }));

        Log.i(getLocalClassName(), "Awaiting completion");
    }
}