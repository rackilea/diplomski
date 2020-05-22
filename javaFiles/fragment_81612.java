if (ContextCompat.checkSelfPermission(MainActivity.this,
        Manifest.permission.READ_PHONE_STATE)
        != PackageManager.PERMISSION_GRANTED) {

 
    if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
            Manifest.permission.READ_PHONE_STATE)) {
        
    } else {
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.READ_PHONE_STATE,
                MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);

    }
} else {
    //Read IMEI here
}