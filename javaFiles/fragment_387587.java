List<ApplicationInfo> packages;
 PackageManager pm;
 pm = getPackageManager();
 //  get a list of installed apps.
 packages = pm.getInstalledApplications(0);
  ActivityManager mActivityManager = (ActivityManager) context
            .getSystemService(Context.ACTIVITY_SERVICE);
 for (ApplicationInfo packageInfo : packages) {
 //packageInfo.packageName contains package name
  }