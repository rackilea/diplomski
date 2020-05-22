public class MainActivity extends AppCompatActivity {    
    AppBarLayout appBarLayout;
    int bgPick = LoginMain.getBgPick();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        randomHeader();
    }
}