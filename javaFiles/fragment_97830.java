@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test2);
    new GetDataSync().execute();
}

String saldo = "";

public class GetDataSync extends AsyncTask<Void, Void, Void> {


    @Override
    protected Void doInBackground(Void... params) {
        try {
            getData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        txtUser.setText(saldo);
    }
}

private void getData() throws IOException, JSONException {
    JSONObject json = readJsonFromUrl("http://piggybank.wordmediavormgever.nl/getSaldo.php");
    try {
        String response = json.getString("saldo");
        Log.e("AAAAAAAAA %s", response);
        saldo = response;

    } catch (JSONException e) {

        e.printStackTrace();
    }
}

private String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
        sb.append((char) cp);
    }
    return sb.toString();
}

public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String jsonText = readAll(rd);
        JSONObject json = new JSONObject(jsonText);
        return json;
    } finally {
        is.close();
    }
}