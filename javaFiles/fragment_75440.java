public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        textView = findViewById(R.id.sdweedew);
        new ConnectionTest().execute();
    }


     class ConnectionTest extends AsyncTask<Void, Void, String> {

        String loginFormUrl = "https://intranet.tam.ch/";

        @Override
        protected String doInBackground(Void... voids) {
            try {
                Connection.Response loginForm = Jsoup.connect(loginFormUrl).method(Connection.Method.GET)
                        .execute();
                return loginForm.statusMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            if (textView != null) {
                textView.setText(s);
            }
            super.onPostExecute(s);
        }
    }
    }