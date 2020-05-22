package com.example.eddie.drawerapp2;
//I did not include the imports to make this shorter

public class BaseActivity extends AppCompatActivity implements
    NavigationView.OnNavigationItemSelectedListener
{
protected FrameLayout frameLayout;
private DrawerLayout drawer;
private NavigationView navView;

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.base_activity);


    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    android.support.v7.app.ActionBarDrawerToggle toggle = new android.support.v7.app.ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    frameLayout = (FrameLayout)findViewById(R.id.content_frame);
    drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
    navView = (NavigationView)findViewById(R.id.nav_view);

    navView.setNavigationItemSelectedListener(this);


}

     /* Overriding all setContentView methods to put the content view to the FrameLayout frameLayout
  * so that, we can make other activity implementations looks like normal activity subclasses.
  */

@Override
public void setContentView(int layoutResID) {
    if (frameLayout != null) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        View stubView = inflater.inflate(layoutResID, frameLayout, false);
        frameLayout.addView(stubView, lp);
    }
}

@Override
public void setContentView(View view) {
    if (frameLayout != null) {
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        frameLayout.addView(view, lp);
    }
}

@Override
public void setContentView(View view, ViewGroup.LayoutParams params) {
    if (frameLayout != null) {
        frameLayout.addView(view, params);
    }
}



@Override
public boolean onNavigationItemSelected(@NonNull MenuItem item) {
// Handle navigation view item clicks here.
    int id = item.getItemId();

    if (id == R.id.nav_camera) {
        // Handle the camera action
    } else if (id == R.id.nav_gallery) {

    } else if (id == R.id.nav_slideshow) {

    } else if (id == R.id.nav_manage) {

    } else if (id == R.id.nav_share) {

    } else if (id == R.id.nav_send) {

    }

    drawer.closeDrawer(GravityCompat.START);
    return true;
}
}