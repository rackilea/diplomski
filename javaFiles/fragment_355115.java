//Hamburger icon of your toolbar
            ImageButton hamburger= (ImageButton) findViewById(R.id.toolbarHamburger);
            hamburger.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    if (drawerLayout.isDrawerOpen(Gravity.RIGHT))
                        drawerLayout.closeDrawer(Gravity.RIGHT);
                    else
                        drawerLayout.openDrawer(Gravity.RIGHT);
                }
            });