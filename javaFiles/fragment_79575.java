public class MainActivity extends AppCompatActivity {



    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_EMAIL = "email";
    String requestType="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        switch (requestType){
            case "Registration":
                Map<String, String> dynamicParams = new HashMap<String, String>();
                dynamicParams.put(KEY_USERNAME, "userName");
                dynamicParams.put(KEY_PASSWORD, "password");
                dynamicParams.put(KEY_EMAIL, "email");
                final String REGISTER_URL_REG = "http://foo.com/volleyRegister.php";
                performVolleyRequest(dynamicParams,REGISTER_URL_REG);
                break;
            case "Login":
                Map<String, String> dynamicParamsLogin = new HashMap<String, String>();
                dynamicParamsLogin.put(KEY_USERNAME, "userName");
                dynamicParamsLogin.put(KEY_PASSWORD, "password");
                final String REGISTER_URL_LOGIN = "http://foo.com/volleyLogin.php";
                performVolleyRequest(dynamicParamsLogin,REGISTER_URL_LOGIN);
                break;
        }

    }



    private void performVolleyRequest(final Map<String, String> paramDynamic,final String REGISTER_URL) {
        StringRequest stringRequest = new StringRequest(DownloadManager.Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params=paramDynamic;
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}