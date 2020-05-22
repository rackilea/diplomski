@Override
 public void onRequestPermissionsResult (int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    switch (requestCode) {
        case General.REQUESTPERMISSION:
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //reload my activity with permission granted or use the features that required the permission

            } else {
                Messenger.makeToast(getContext(), R.string.noPermissionMarshmallow);
            }
            break;
    }
}