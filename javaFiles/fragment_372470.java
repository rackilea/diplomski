public class AndroidServer2 extends Activity {

    private Button closeConnectionButton;
    int serverPort = 8080;
    Thread fst = new Thread(new MyServer(this)); //declaration of a new thread

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_server2);
    }

    @Override
    protected void onResume(){
        super.onResume();
        if (fst.isAlive() == false){
            fst.start();
        }
    }

    @Override
      protected void onPause() {
        super.onPause();
        try {
            fst.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
      }

    public void setButtonVisible() {
        closeConnectionButton.setVisibility(View.VISIBLE);
    }
}