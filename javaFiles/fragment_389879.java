public class MainActivity extends AppCompatActivity {

    Handler uiHandler = new Handler();

    Document siteDoc;
    String a;
    Elements p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn= (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new siteGetter().execute();
            }
        });

    }

    private class siteGetter extends AsyncTask < Void, Void, String>{

        @Override
        protected String doInBackground(Void... voids) {
            try {
                siteDoc = Jsoup.connect("http://hashtagedu.ir").get();
                displaydata();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return null;
        }
    }

    public void displaydata(){
        p = siteDoc.getElementsByTag("p");
        a=p.text();

        uiHandler.post(new Runnable() {
            @Override
            public void run() {
                TextView tv= (TextView) findViewById(R.id.textView);
                tv.setText(a);
            }
        });
    }
}