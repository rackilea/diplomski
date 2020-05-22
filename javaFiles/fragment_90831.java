protected Context instance() {
        ShadowApplication shadowApp = Shadows.shadowOf(this);
        shadowApp.grantPermissions("android.permission.INTERNET");

        return shadowApp.getApplicationContext();
    }