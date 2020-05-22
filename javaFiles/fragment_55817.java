if (checkReadPermission() && checkWritePermission()) {
   Log.d("ALL PERMISSIONS","All permissions granted");
} else {
    requestInternetPermission();
    requestReadPermission();
    requestWritePermission();
}