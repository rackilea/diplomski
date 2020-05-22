public class MainActivity extends Activity {
//saved data stuff needed
SharedPreferences preferences;   //declare them
Editor edit;
//private data using saved data
String autoclearKEY = "us.mattmccoy.meanfind.AUTOCLEAR";
boolean autoclear;
        @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    SharedPreferences preferences; = this.getSharedPreferences("us.mattmccoy.meanfind",   Context.MODE_PRIVATE);
    Editor edit = preferences.edit();   //initialize them
    boolean autoclear = preferences.getBoolean(autoclearKEY, false);
    addListenerBoxes();
    if(autoclear == true){
        acBox.setChecked(true);
    }else{
        acBox.setChecked(false);
    }