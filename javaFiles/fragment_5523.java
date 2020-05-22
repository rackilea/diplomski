private boolean checkAndRequestPermissions() {

    int ACCESS_FINE_LOCATION = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
    int READ_PHONE_STATE = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);

    List<String> listPermissionsNeeded = new ArrayList<>();

    if (READ_PHONE_STATE != PackageManager.PERMISSION_GRANTED) {
        listPermissionsNeeded.add(Manifest.permission.READ_PHONE_STATE);
    }
    if (ACCESS_FINE_LOCATION != PackageManager.PERMISSION_GRANTED) {
        listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
    }

    if (!listPermissionsNeeded.isEmpty()) {
        ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray
                (new String[listPermissionsNeeded.size()]), 101);
        return false;
    }
    return true;
}