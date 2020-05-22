private boolean checkThisApp(String uri) {
    PackageManager myPackageManager = getPackageManager();
    boolean app_installed;
    try {
        myPackageManager.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
        app_installed = true;
    }
    catch (PackageManager.NameNotFoundException e) {
        app_installed = false;
    }
    return app_installed;
}