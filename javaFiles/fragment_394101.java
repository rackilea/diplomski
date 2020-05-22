public class SetMacroManualActivity extends AppCompatActivity {
  private static final String TAG = "myMessage";
  private static final String MY_PREF = "MyPreferences";
  @Override
  public void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    // load the layout
    setContentView(R.layout.filters); 
    SharedPreferences prefs = getSharedPreferences(MY_PREF, MODE_PRIVATE);
    SharedPreferences.Editor editor = prefs.edit();