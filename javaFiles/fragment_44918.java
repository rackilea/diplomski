public class ExampleActivity extends Activity implements OnItemClickListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set layout etc

        textView = (TextView) findViewById(some id); //Find the TextView

        ListView list = (ListView) findViewById(some id); //Find the ListView
        //Set adapter etc.
        list.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
        textView.setText("Some text"); //Get the text from your adapter for example
    }
}