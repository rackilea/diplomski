public class MainActivity extends BaseActivity {


    TextView titleToolbarTV;
    ImageView  hamburgerIV;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar; 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  

        titleToolbarTV = (TextView)findViewById(R.id.title_text); 

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        hamburgerIV = (ImageView)findViewById(R.id.hamburger);
        drawerLayout = (DrawerLayout) findViewById(R.id.base_layout);
        navigationView = (NavigationView)findViewById(R.id.navigation_drawer);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        loginPreferences = new LoginPreferences(MainActivity.this);
        user = loginPreferences.getUser();
        hamburgerIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else{
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

 }
 }