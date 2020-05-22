@Override
public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    if (requestCode == REQUEST_PERMISSION) {
        // Permission check if the user granted/denied them you may want to group the rationale in a single dialog        
        for (int i = 0, len = permissions.length; i < len; i++) {
            String permission = permissions[i];
            if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
            // denied the permission
                boolean showRationale = shouldShowRequestPermissionRationale( permission );
                if (! showRationale) {
                    // User ticked "never ask again"
                    // Show some meaningful message 
                } else if (Manifest.permission.WRITE_CONTACTS.equals(permission)) {
                    showRationale(permission, R.string.permission_denied_contacts);
                    // NOT ticked "never ask again"
                } else if ( /* possibly check more permissions...*/ ) {
                }
            }
        }
    }
}