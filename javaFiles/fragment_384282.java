public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView mNavigationView;
    View mHeaderView;

    TextView textViewUsername;
    TextView textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ...................
        ..........................

        // NavigationView
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);

        // NavigationView Header
        mHeaderView =  mNavigationView.getHeaderView(0);

        // View
        textViewUsername = (TextView) mHeaderView.findViewById(R.id.textViewUsernameNav);
        textViewEmail= (TextView) mHeaderView.findViewById(R.id.textViewEmailNav);

        // Set username & email
        textViewUsername.setText(SharedPrefManager.getInstance(this).getUsername());
        textViewEmail.setText(SharedPrefManager.getInstance(this).getEmail());


        mNavigationView.setNavigationItemSelectedListener(this);
    }
}