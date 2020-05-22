public void checkDrawOverlayPermission() {
    /** check if we already  have permission to draw over other apps */
    if (!Settings.canDrawOverlays(this)) { // WHAT IF THIS EVALUATES TO FALSE.
        /** if not construct intent to request permission */
        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                Uri.parse("package:" + getPackageName()));
        /** request permission via start activity for result */
        startActivityForResult(intent, REQUEST_CODE);
    } else { // ADD THIS.
        // Add code to bind and start the service directly.
    }
}