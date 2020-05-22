result = new DrawerBuilder()
            .withActivity(this)
            .withTranslucentStatusBar(false)
            .withActionBarDrawerToggle(false)
            .addDrawerItems(drawerItemsArray)
            .withSavedInstance(savedInstanceState)
            .withOnDrawerListener(new Drawer.OnDrawerListener() {
                @Override
                public void onDrawerOpened(View view) {
                }

                @Override
                public void onDrawerClosed(View view) {
                }

                @Override
                public void onDrawerSlide(View view, float v) {
                    removeSoftKeyboard();
                }
            })
            .build();