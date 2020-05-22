final PackageManager pkgmgr = getApplicationContext().getPackageManager();
ApplicationInfo appinfo;
try {
    appinfo = pkgmgr.getApplicationInfo( this.getPackageName(), 0);
} catch (final NameNotFoundException e) {
    appinfo = null;
}
final String applicationName = (String) (appinfo != null ? pkgmgr.getApplicationLabel(appinfo) : "(unknown)");