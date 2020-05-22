public class MainActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Track app opens.
    ParseAnalytics.trackAppOpened(getIntent());
    Intent i = getIntent();
    Bundle extras = i.getExtras();
    if (extras != null) {
        System.out.println("MESSAGGE " + extras.get("com.parse.Data"));
        System.out.println("Chanell " + extras.get("com.parse.Channel"));
        System.out.println("DATA " + extras.keySet());
        for (String k : extras.keySet()) {
            System.out.println("K " + k);

        }
    }
}}