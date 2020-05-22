public class MainActivity extends ActionBarActivity {
    ListView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l=(ListView)findViewById(R.id.listView);

    }


}