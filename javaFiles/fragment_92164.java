public class Example extends Activity {

    private static Handler staticHandler;
    private TextView currentDownloadField;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                this.currentDownloadField.setText(""+ msg.what);
            }
        }
        staticHandler = handler;
        setContentView(R.layout.main_view);
        currentDownloadField = (TextView)findViewById(R.id.download_field);
    }

    @Override
    protected void onDestroy() {
        staticHandler = null;
    }

    public static void sendMessage(int id) {
        staticHandler.sendEmptyMessage(id); // just the what() is filled with the id
    }
}