AssetManager assetManager = getResources().getAssets();
InputStream inputStream = null;

    try {
        inputStream = assetManager.open("foo.txt");
            if ( inputStream != null)
                Log.d(TAG, "It worked!");
        } catch (IOException e) {
            e.printStackTrace();
        }