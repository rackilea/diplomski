public class MainActivity extends FragmentActivity {

Button dfragbutton;
Button alertdfragbutton;
FragmentManager fm = getSupportFragmentManager();

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // Get the view from activity_main.xml
    setContentView(R.layout.activity_main);

    // Locate the button in activity_main.xml
    dfragbutton = (Button) findViewById(R.id.dfragbutton);
    alertdfragbutton = (Button) findViewById(R.id.alertdfragbutton);

    // Capture button clicks
    dfragbutton.setOnClickListener(new OnClickListener() {
        public void onClick(View arg0) {
            DFragment dFragment = new DFragment();
            // Show DialogFragment
            dFragment.show(fm, "Dialog Fragment");
        }
    });

    // Capture button clicks
    alertdfragbutton.setOnClickListener(new OnClickListener() {
        public void onClick(View arg0) {
            AlertDFragment alertdFragment = new AlertDFragment();
            // Show Alert DialogFragment
            alertdFragment.show(fm, "Alert Dialog Fragment");
        }
    });
}
 }