public  boolean isStoragePermissionGranted() {
if (Build.VERSION.SDK_INT >= 23) {
    if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_GRANTED) {
        Log.v(TAG,"Permission is granted");
        return true;
    } else {

        Log.v(TAG,"Permission is revoked");
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        return false;
    }
}
else { //permission is automatically granted on sdk<23 upon installation
    Log.v(TAG,"Permission is granted");
    return true;
}