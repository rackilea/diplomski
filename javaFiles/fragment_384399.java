public class ActivityName extends Activity {

   private string MacId = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_layout);

        MacId = getBSSID();

       //Other functions
    }