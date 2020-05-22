public class MainActivity extends AppCompatActivity {

String TAG;
String ActivityState;
int instanceTimes; //number of times instance is called
String Act_keys;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    setContentView(R.layout.activity_main);
    TAG = getResources().getString(R.string.app_name); //Logcat tag
    //recover instance state
    if(savedInstanceState!=null)
    {
       ActivityState = savedInstanceState.getString(Act_keys);
    }
    else
    {
       instanceTimes=0;
       Act_keys="";
    }
}