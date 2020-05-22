// Displays a permission dialog when requested for devices M and above.
@Override
public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                       int[] grantResults) {
    if (requestCode == MY_PERMS_REQUEST_CAMERA) {

        // User accepts the permission(s).
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            v.startAnimation(animSlide);
            allowCamera.setVisibility(View.GONE);
            w = 1;
        } else { // User denies the permission.
            Toast.makeText(this, "Please grant the permission", Toast.LENGTH_SHORT).show();
        }
    }
}