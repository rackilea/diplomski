/**
 * Created by AndyRoid on 5/23/15.
 */
public class MainActivity extends AppCompatActivity {

public static final String TAG = MainActivity.class.getSimpleName();

public static final String mPath = "adventur.txt";
private QuoteBank mQuoteBank;
private List<String> mLines;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mQuoteBank = new QuoteBank(this);
    mLines = mQuoteBank.readLine(mPath);
    for (String string : mLines)
        Log.d(TAG, string);
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
        return true;
    }

    return super.onOptionsItemSelected(item);
}
}