Intent i;
PackageManager manager = getPackageManager();
try {
    i = manager.getLaunchIntentForPackage("com.google.android.apps.plus.photos");
    if (i == null)
        throw new PackageManager.NameNotFoundException();
    i.addCategory(Intent.CATEGORY_LAUNCHER);
    startActivity(i);
} catch (PackageManager.NameNotFoundException e) {

}