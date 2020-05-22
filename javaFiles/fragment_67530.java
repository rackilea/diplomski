@Override
public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[],@NonNull int[] grantResults) {
    if(requestCode==REQUESTID){
        // If request is cancelled, the result arrays are empty.
        if (!(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {

            // permission was not granted, boo!
            //show the permission rationale if the user did not click never show again

            if(ActivityCompat.shouldShowRequestPermissionRationale(LoginActivity.this,android.Manifest.permission.ACCESS_FINE_LOCATION)){
                //means user did not choose to never show permissions again. show the alert dialog
                //Show a message explaining why the permission is necessary
                //This explanation will only be shown if the user hasn't clicked do not show again on the permission dialog
            }

        }
    }
}