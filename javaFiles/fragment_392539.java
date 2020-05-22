Intent intent = new Intent("com.google.android.apps.dashclock.Extension");
    for (ResolveInfo info : mgrPackages.queryIntentServices(intent, 0)) {
        String packageName = info.serviceInfo.applicationInfo.packageName;
        // you can then filter by packageName.startsWith("com.mridang");
        Log.d("Packages", "package = " + packageName);
    }