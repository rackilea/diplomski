final PackageManager packageManager = getPackageManager();

try {
    final ApplicationInfo applicationInfo = packageManager.getApplicationInfo(getPackageName(), 0);
    if ("com.android.vending".equals(packageManager.getInstallerPackageName(applicationInfo.packageName))) {
        // App was installed by Play Store
    }
} catch (final NameNotFoundException e) {
    e.printStackTrace();
}