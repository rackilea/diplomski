private boolean isPackageInstalled(String packageName, PackageManager packageManager) {

    boolean found = true;

    try {

        packageManager.getPackageInfo(packageName, 0);
    } catch (PackageManager.NameNotFoundException e) {

        found = false;
    }

    return found;
}