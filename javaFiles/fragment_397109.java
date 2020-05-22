public String X = "";

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test);

    Button submit=(Button)findViewById(R.id.submit); 
    submit.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

            class MyAsyncTask extends AsyncTask<DownloadManager.Request, Void, String> {

                @Override
                protected String doInBackground(DownloadManager.Request... params) {
                    try {
                        translatedText = Translate.execute(X, Language.AUTO_DETECT, Language.FRENCH);

                        return translatedText;

                    } catch (Exception e) {
                        e.printStackTrace();
                        return "";
                    }

                    return null;
                }
            }
            new MyAsyncTask().execute();
        }
    });
}