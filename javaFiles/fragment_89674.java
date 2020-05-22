public class MainActivity extends ActionBarActivity {
    @Inject Repository myRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApplication app=(MyApplication)getApplication();
        app.getObjectGraph().inject(this);
        Log.v("testing", repository.getAllString().get(0));
    }
}