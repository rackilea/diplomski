public class MainActivity extends Activity {
    public static final String UI_THREAD = "uithread"; 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread thread = Thread.currentthread();
        thread.setName(UI_THREAD);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    //This method will return true if it runs on a different thread else will return false
    public boolean testMethodIsRunningOnDifThread(){
      Thread thread = Thread.currentThread();
      if(thread.getName().equals(UI_THREAD))
        return false;
      }
      else{
        return true;
      } 
    }