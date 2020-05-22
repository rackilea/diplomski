private Context mContext=YourActivity.this;

    private static final int REQUEST = 112;


    if (Build.VERSION.SDK_INT >= 23) {
        String[] PERMISSIONS = {android.Manifest.permission.READ_EXTERNAL_STORAGE,android.Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (!hasPermissions(mContext, PERMISSIONS)) {
            ActivityCompat.requestPermissions((Activity) mContext, PERMISSIONS, REQUEST );
        } else {
            //do here
        }
    } else {
         //do here
    }