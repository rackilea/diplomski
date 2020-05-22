private static final int PERMISSIONS_READ_STORE = 2;

private void requestPermissions() {
    String [] permissions=new String[]{
            Manifest.permission.READ_EXTERNAL_STORAGE
    };
    List<String> listPermissionsNeeded = new ArrayList<>();
    for (String permission:permissions) {
        if (ContextCompat.checkSelfPermission(this,permission )!= PackageManager.PERMISSION_GRANTED){
            listPermissionsNeeded.add(permission);
        }
    }
    if (!listPermissionsNeeded.isEmpty()) {
        ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), PERMISSIONS_READ_STORE);
    }
}

@Override
public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    if(requestCode == PERMISSIONS_READ_STORE) {
        if (grantResults.length > 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
          // Permissions ok get the files
        }
    }else {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }