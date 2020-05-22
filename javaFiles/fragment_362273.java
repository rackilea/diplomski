@Override
public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if (requestCode == REQUEST_CODE_CALL) {
        if (grantResults.length == 1
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            call();
        } else {
            Toast.makeText(ContactUsActivity.this, "Permission is needed for proper working of this app", Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE_CALL);
        }
    }
}