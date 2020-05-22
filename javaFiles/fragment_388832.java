public class EpsoftSMSActivity extends Activity {
    /** Called when the activity is first created. */


    final MyDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        db = new MyDatabase(getApplicationContext());



        db.open();  //apriamo il db