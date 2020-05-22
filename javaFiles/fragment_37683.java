final PackageManager pm = getPackageManager();
//get a list of installed apps.
List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

for (ApplicationInfo packageInfo : packages) {
    Log.d(TAG, "Installed package :" + packageInfo.packageName);
    Log.d(TAG, "Source dir : " + packageInfo.sourceDir);
    Log.d(TAG, "Launch Activity :" + pm.getLaunchIntentForPackage(packageInfo.packageName)); 
}