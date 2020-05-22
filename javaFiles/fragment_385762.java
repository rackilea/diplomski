public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(this);

    }
    public void onClick(View v) {

        new MyAsyncTask().execute("lol");
    }
    private class MyAsyncTask extends AsyncTask<String, Integer, Double> {


        @Override
        protected Double doInBackground(String... params) {
            // TODO Auto-generated method stub


            try {
                URL u = new URL("http://www.sahdeepsingh.com");
                HttpURLConnection c = (HttpURLConnection)u.openConnection();
                c.connect();

            }
            catch (Exception e) {
                Log.v("TAG", "Error is " + e.getMessage());
            }
            return null;
        }
    }
}