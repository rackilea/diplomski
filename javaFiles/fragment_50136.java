NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
View header_view = navigationView.getHeaderView(0);
ImageView img = (ImageView) header_view.findViewById(R.id.profile_image);
img.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this, Profile.class));
        }
    });