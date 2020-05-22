public class MainActivity extends AppCompatActivity {

  public String response;
  TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    textView = (TextView) findViewById(R.id.rTextView);

    RequestQueue queue = Volley.newRequestQueue(this);
    String url = "yourWebserviceUrl";

    // Request a string response from the provided URL. 
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
      new Response.Listener < String > () {
        @Override
        public void onResponse(String response) {
          textView.setText("Response is: " + response);
        }
      }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
          textView.setText("That didn't work!");
        }
      });
    // Add the request to the RequestQueue. 
    queue.add(stringRequest);

  }

}