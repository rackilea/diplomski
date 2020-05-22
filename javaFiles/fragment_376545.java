public  boolean isPermissionGranted() {
    if (Build.VERSION.SDK_INT >= 23) {
        if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
                == PackageManager.PERMISSION_GRANTED) {
            Log.v("TAG","Permission is granted");
            return true;
        } else {

            Log.v("TAG","Permission is revoked");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            return false;
        }
    }
    else { //permission is automatically granted on sdk<23 upon installation
        Log.v("TAG","Permission is granted");
        return true;
    }
}


 @Override
public void onRequestPermissionsResult(int requestCode,
                                       String permissions[], int[] grantResults) {
    switch (requestCode) {

        case 1: {

            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
                call_action();
            } else {
                Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        // other 'case' lines to check for other
        // permissions this app might request
    }
 }