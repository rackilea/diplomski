public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);     
        ScrollView v = (ScrollView) findViewById(R.id.scrollProfile); 
        v.requestFocus();


    }
}