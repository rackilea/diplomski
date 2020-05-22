private void manageCameraPerm() {

    // Requests permission for devices with versions Marshmallow (M)/API 23 or above.
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (ActivityCompat.checkSelfPermission(getContext(),
            android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{Manifest.permission.CAMERA},
                MY_PERMS_REQUEST_CAMERA); // Invokes onRequestPermissionsResult()

            return;
        }
    }