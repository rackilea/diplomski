NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
View header_view = navigationView.getHeaderView(0);
header_view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, Profile.class));
        }
    });