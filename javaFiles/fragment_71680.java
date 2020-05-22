public static Camera getCameraInstance() {
    Camera c = null;
    try {
        c = Camera.open(); // attempt to get a Camera instance
    } catch (Exception e) {
        Log.e(TAG, e.getMessage());
        // Camera is not available (in use or does not exist)
    }
    return c; // returns null if camera is unavailable
}