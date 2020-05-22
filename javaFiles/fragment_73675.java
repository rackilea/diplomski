public class TestActivity extends Activity {
/** Called when the activity is first created. 
 * @return */

@Override
public void onCreate(Bundle savedInstanceState) {    
super.onCreate(savedInstanceState);          


setContentView(R.layout.main);

new Connect(this).execute();
}