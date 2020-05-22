@Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        switch (requestCode) {

            case REQUEST_WRITE_STORAGE:
                if (canAccessLocation()) {
                    //reload my activity with permission granted or use the features what required the permission
                    System.out.println("permission grantedddd");

                } else {
                    Toast.makeText(this, " Please consider granting it this permission", Toast.LENGTH_LONG).show();
                }
                break;
        }
    }


    private boolean canAccessLocation() {
        return (hasPermission(Manifest.permission.ACCESS_FINE_LOCATION));
    }

    private boolean hasPermission(String perm) {
        return (PackageManager.PERMISSION_GRANTED ==      ContextCompat.checkSelfPermission(this, perm));
    }