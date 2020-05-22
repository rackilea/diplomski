@Override
public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
    switch (requestCode) {
        case PERMISSION_READ_STATE: {
            if (grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // permission granted!
                // you may now do the action that requires this permission
            } else {
                // permission denied
            }
            return;
        }

    }
}