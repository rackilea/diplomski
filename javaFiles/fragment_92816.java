TabHost tabHost = getTabHost();

// First Tab
TabSpec firstspec = tabHost.newTabSpec("List");
// setting Title for the Tab
listspec.setIndicator("List View");

Intent firstIntent = new Intent(this, AddressActivity.class);
firstIntent.putExtra("Position", position);
firstspec.setContent(firstIntent );

// Second Tab
TabSpec secondspec = tabHost.newTabSpec("Map");
secondspec.setIndicator("Map View");

Intent secondIntent = new Intent(this, MapActivity.class);
secondIntent.putExtra("Position", position);
secondspec.setContent(secondIntent );


TabSpec thirdspec = tabHost.newTabSpec("Third");
thirdspec.setIndicator("Third View");

Intent thirdIntent = new Intent(this, ThirdActivity.class);
thirdIntent.putExtra("Position", position);
thirdspec.setContent(thirdIntent );


// Adding all TabSpec to TabHost
tabHost.addTab(firstspec); // First tab
tabHost.addTab(secondspec); // Second tab
tabHost.addTab(thirdspec); // Third Tab