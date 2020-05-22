public class MainActivity extends AppCompatActivity implements VolleyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        companyLogin("abc", "123");
    }
    public interface VolleyCallback {
        void onSuccess(String result);
    }

    public void companyLogin(String companyname, String password) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "http://...";
        final Map<String, String> params = new HashMap<String, String>();
        params.put("name", companyname);
        params.put("pwd", password);

        Intent volley_service = new Intent(MainActivity.this, VolleyAPIService.class);
        MainActivity.this.startService(volley_service);

        VolleyAPIService volleyAPIService = new VolleyAPIService();

        // Assign the callback here to listen the response from the API service.
        volleyAPIService.callback = this; 
        volleyAPIService.volleyPost(URL, params, MainActivity.this);
    }

    @Override
    public void onSuccess(String result) {
        // Handle the success or failure here
        if (!result.isEmpty()) {
            Intent userLoginActivity = new Intent(MainActivity.this, UserLogin.class);
            startActivity(userLoginActivity);
        } else {
            AlertDialog.Builder login_failed = new AlertDialog.Builder(MainActivity.this);
            login_failed.setMessage("Login Failed, invalid credentials")
                 .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {

                     }
                 });

             AlertDialog alert = login_failed.create();
             alert.show();
        }
    }
}