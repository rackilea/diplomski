public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main); // Using layout activity_main.xml

        // You try to set a simple text on the view (TextView) previously added
        TextView text = (TextView) findViewById(R.id.textView1);
        text.setText("Simple Text");  // And you get an error here!

        /*
         * You do an fragment transaction to add PlaceholderFragment Fragment
         * on screen - this below snippnet is automatically created.
        */
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment()).commit();
        }
    }