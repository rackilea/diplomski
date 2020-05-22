public class MainActivity extends AppCompatActivity {

    private static final String DEBUG_TAG = "HttpExample";
    ArrayList<Team> teams = new ArrayList<Team>();
    ListView listview;
    Button btnDownload;
    TeamsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        listview = (ListView) findViewById(R.id.listview);
        btnDownload = (Button) findViewById(R.id.btnDownload);
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            btnDownload.setEnabled(true);
        } else {
            btnDownload.setEnabled(false);
        }
    }

    public void buttonClickHandler(View view) {
        new DownloadWebpageTask(new AsyncResult() {
            @Override
            public void onResult(JSONObject object) {
                processJson(object);
            }
        }).execute("https://spreadsheets.google.com/tq?key=1424bS7kU8nJbHdu4QdoAFdIdWDSnmEnj2NqfMb6rPTU");

    }

    private void processJson(final JSONObject object) {
        try {
            JSONArray rows = object.getJSONArray("rows");
            for (int r = 0; r < rows.length(); ++r) {
                JSONObject row = rows.getJSONObject(r);
                JSONArray columns = row.getJSONArray("c");
                int Code = columns.getJSONObject(0).getInt("v");
                String Name = columns.getJSONObject(1).getString("v");
                String Father = columns.getJSONObject(3).getString("v");
                String Sessional = columns.getJSONObject(4).getString("v");
                //String Comments = columns.getJSONObject(5).getString("v");
                String Comments = "Error";
                Team team = new Team(Code, Name, Father, Sessional, Comments);
                teams.add(team);
                }
            adapter = new TeamsAdapter(MainActivity.this, R.layout.team, teams);
            listview.setAdapter(adapter);
         } catch (JSONException e) {
             e.printStackTrace();
         }
     }
}