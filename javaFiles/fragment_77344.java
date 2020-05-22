public class Test extends ListActivity  {
 Prefs myprefs = null;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.listplaceholder);
    ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

 //myprefs can only be null at this point, you need this line or an equivalent for your Prefs class:
 myprefs = PreferenceManager.getDefaultSharedPreferences(this); 

    JSONObject json = JSONfunctions.getJSONfromURL("http://midsweden.gofreeserve.com/fetch.php?identifier="
        + Test.this.myprefs.getEmail());