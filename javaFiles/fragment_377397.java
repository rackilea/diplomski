// extend this class with "Activity" for API 11+
public class MainActivity extends ActionBarActivity {

@Override
protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // For API 10 and lower only
    getSupportActionBar().show(); // call hide() if you want to hide it.

    // For API 11 and higher only
    getActionBar().show(); // call hide() if you want to hide it.