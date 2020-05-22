public class MainActivity extends Activity {
GView mGView;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.main);  
    // initialize here
    mGView = (GView)findViewById(R.id.gview);
    // put this anywhere and make sure you do not violate UI thread constraint for making any UI changes
    mGview.<yourmethod>()
 ...