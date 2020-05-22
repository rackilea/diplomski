if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
        != PackageManager.PERMISSION_GRANTED) {

    // Should we show an explanation?
    if (shouldShowRequestPermissionRationale(
            Manifest.permission.READ_EXTERNAL_STORAGE)) {
        // Explain to the user why we need to read the contacts
    }

    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
            MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);

    // MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE is an
    // app-defined int constant that should be quite unique

    return;
}