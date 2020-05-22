tabLayout.addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {
                 Toast.makeText(MainActivity.this, "Tab clicked", 
   Toast.LENGTH_LONG).show();
            }