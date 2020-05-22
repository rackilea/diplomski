protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Log.i(TAG, "Start");

    client = new Client();
    client.addListener(new Listener() {
            public void received(Connection c, Object p) {

            }
    });
    client.start();
    new ConnectToServer.execute();


    }
public class ConnectToServer extends AsyncTask<String, int[], String>
{
    @Override
    protected String doInBackground(String... arg0) {
        // TODO Auto-generated method stub
        try {
             client.connect(5000, ip, tcp, udp);
             Log.i(TAG, "conected");
        } catch(IOException e) {

        Log.i(TAG, "Error: " + e.getMessage());
        return null;
    }
}