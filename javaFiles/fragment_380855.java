public class Clock extends Activity{
@SuppressLint("NewApi")

TextView textview; // declare it here

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

//get intent from IncomeCounter
Intent intent = getIntent();
Bundle bundle = new Bundle();

//create textview
textview = new TextView(this);  // and initialize it here