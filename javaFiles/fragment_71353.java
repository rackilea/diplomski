Bool isPermissionGiven = false;
if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission. READ_EXTERNAL_STORAGE)
            == PackageManager.PERMISSION_GRANTED) {
        Log.v(TAG,"Permission is granted");
        isPermissionGiven =  true;
    } else {

        Log.v(TAG,"Permission is revoked");
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        isPermissionGiven =  false;
    }

if (isPermissionGiven){
    new Environment(this)
}