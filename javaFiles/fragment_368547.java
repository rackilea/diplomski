// lets change the variable names first.
private NavigationView mNavigationView;

mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
DrawerName = (TextView) mNavigationView.getHeaderView(0).findViewById(R.id.DrawerNameTv);

// Now set the text here
DrawerName.setText("Test");