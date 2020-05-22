/**
     * Prepares the SDCard with all we need
     */
    private void prepareSDCard() {
        // Create app dir in SDCard if possible
        File path = new File("/sdcard/MyAppDirectory/");
        if(! path.isDirectory()) {
            if ( path.mkdirs() )
            {
                Log.d(TAG,"Directory created: /sdcard/MyAppDirectory");
            }
            else
            {
                Log.w(TAG,"Failed to create directory: /sdcard/MyAppDirectory");
            }
        }
    }