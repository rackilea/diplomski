if (ContextCompat.checkSelfPermission(thisActivity,Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {


if (ActivityCompat.shouldShowRequestPermissionRationale(thisActivity,
        Manifest.permission.READ_EXTERNAL_STORAGE)) {

    // Show an explanation to the user *asynchronously* -- don't block
    // this thread waiting for the user's response! After the user
    // sees the explanation, try again to request the permission.

} else {

    // No explanation needed, we can request the permission.

    ActivityCompat.requestPermissions(thisActivity,
            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
            REQUEST_PERMISSION);

    // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
    // app-defined int constant. The callback method gets the
    // result of the request.
}