final PackageManager pm = getPackageManager();
//get a list of installed apps.
List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

for (ApplicationInfo packageInfo : packages) {
    if(applicationInfo.loadLabel(pm).toString().equalsIgnoreCase(appName){
      string packageName = packageInfo.packageName;
    }
    Log.d(TAG, "Installed package :" + packageInfo.packageName);
    Log.d(TAG, "Launch Activity :" + pm.getLaunchIntentForPackage(packageInfo.packageName)); 
}
// the getLaunchIntentForPackage returns an intent that you can use with startActivity()