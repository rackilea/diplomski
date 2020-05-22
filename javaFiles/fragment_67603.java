@Override
public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == 411) {
        if (grantResults.length == 0 || grantResults == null) {
             // show dialog that you need access to go ahead
        } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // Your code here permission granted
        } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
             // show dialog that you need access to go ahead
        }
    }
}