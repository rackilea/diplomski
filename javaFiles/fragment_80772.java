public class IPControl extends Activity {
    private ProgressDialog pd = null;
    private String data = null;
    private Socket socket;
    private String serverIpAddress;
    private static final int REDIRECTED_SERVERPORT = 32;
    public PrintWriter out;
    public BufferedReader in ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        try{   
            this.pd = ProgressDialog.show(this, "Loading..", "Please Wait...", true, false);
            new AsyncAction().execute();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class AsyncAction extends AsyncTask<String, Void, String> {
        protected Void doInBackground(String... args) { 
            try {
                InetAddress serverAddr = InetAddress.getByName(serverIpAddress);
                socket = new Socket(serverAddr, REDIRECTED_SERVERPORT);
            } catch (UnknownHostException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (! in.ready());
                readBuffer();
                out.println("root\r\n");
                //System.out.print("root\r\n");
                while (! in .ready());
                readBuffer();
                out.println("root\r\n");
                //System.out.print("root\r\n");
                while (! in .ready());
                String msg = "";

                while (in.ready()) {
                    msg = msg + (char) in .read();
                }
            } catch (IOException e) {}

        return null;//returns what you want to pass to the onPostExecute()
    }

    protected void onPostExecute(String result) {
        //resultis the data returned from doInbackground
        IPControl.this.data = result;

        if (IPControl.this.pd != null) {
            IPControl.this.pd.dismiss();
        }
    } 
}