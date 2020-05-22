protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_driver_home);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    NavigationView navigationView = findViewById(R.id.nav_view);
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    mAppBarConfiguration = new AppBarConfiguration.Builder(
            R.id.nav_home, R.id.nav_history, R.id.nav_settings,
            R.id.nav_help, R.id.nav_signout)
            .setDrawerLayout(drawer)
            .build();
    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
    NavigationUI.setupWithNavController(navigationView, navController);
    // This line needs to be after setupWithNavController()
    navigationView.setNavigationItemSelectedListener(this);

}

@Override
public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    switch (menuItem.getItemId()){
        case R.id.nav_history:
            Toast.makeText(this, "fsdfuxc", Toast.LENGTH_LONG).show();
            break;
        case R.id.nav_signout:
            signOut();
            break;
        default:
            // Trigger the default action of replacing the current
            // screen with the one matching the MenuItem's ID
            NavigationUI.onNavDestinationSelected(menuItem, navController);
    }

    DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
}