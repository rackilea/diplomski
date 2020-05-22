public class MyClass extends Activity {
    TextView textview;
    public void onCreate(Bundle bundle) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classement);
        textview = (TextView)findViewById(R.id.textview);
        new NetworkOperation().execute();
    }

    private class NetworkOperation extends AsyncTask<Void, Void, String> {
        protected String doInBackground(Void... params) {
            try {
                URL oracle = new URL("http://www.nationalleague.ch/NL/fr/");
                URLConnection yc = oracle.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
                String inputLine;
                String s1 = "";
                while ((inputLine = in.readLine()) != null)
                    s1 = s1 + inputLine;
                in.close();
                int Berne = s1.indexOf(">SC Bern</td>");
                String s3 = String.valueOf(Berne); 
                return s3;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }      

        protected void onPostExecute(String result) {
            textview.setText(result);
        }
    }
}