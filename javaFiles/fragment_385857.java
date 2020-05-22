/**
     * @return A comma separated list of radios that need to be disabled when airplane mode is on
     */
    private String getGlobalSettingValues() {
        ContentResolver cr = getContentResolver();
        Cursor globalCursor = null;
        String aeroplaneMode = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            globalCursor = cr.query(Settings.Global.CONTENT_URI, null, null, null, null);
            if(globalCursor != null && globalCursor.moveToFirst()){
                aeroplaneMode =  Settings.Global.getString(getApplicationContext().getContentResolver(),Settings.Global.AIRPLANE_MODE_RADIOS);
            }
        } 
        if (globalCursor != null) {
            globalCursor.close();
        }
        return aeroplaneMode;
    }