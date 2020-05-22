public abstract class MyAppCompatActivity extends BaseAppCompatActivity {

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
    CoordinatorLayout activityParentBase = (CoordinatorLayout) getLayoutInflater().inflate(R.layout.activity_navigation_drawer, null);
    RelativeLayout content = (RelativeLayout) activityParentBase.findViewById(R.id.content);
    setContentView(activityParentBase);
    getLayoutInflater().inflate(layoutResID, content, true);
    super.setContentView(activityParentBase);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    toolbar.setTitle("");
    setSupportActionBar(toolbar);
    final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            MyAppCompatActivity.this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

    navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();

            if (id == R.id.nav_item1) {

            } else if (id == R.id.nav_item2) {

            }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    });
    }
}