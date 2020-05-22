/**
 * permission code
 */
private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;

/**
 * requestPermissions and do something
 *
 */
public void requestRead() {
    if (ContextCompat.checkSelfPermission(this,
            Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
    } else {
        readFile();
    }
}

/**
 * do you want to do
 */
public void readFile() {
    // do something
}

/**
 * onRequestPermissionsResult
 *
 * @param requestCode
 * @param permissions
 * @param grantResults
 */
@Override
public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

    if (requestCode == MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE) {
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            readFile();
        } else {
            // Permission Denied
            Toast.makeText(ToolbarActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
        return;
    }
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
}