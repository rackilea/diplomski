if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    boolean result = marshMallowPermission.checkPermissionForReadExtertalStorage();
    if (result) {
        getPdfFromExternalStorage(Environment.getExternalStorageDirectory());
    } else {
        try {
            marshMallowPermission.requestPermissionForReadExtertalStorage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} else {
    getPdfFromExternalStorage(Environment.getExternalStorageDirectory());
}