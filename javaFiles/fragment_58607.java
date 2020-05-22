Intent i = new Intent(Intent.ACTION_VIEW); 
i.setDataAndType(Uri.fromFile(new File(path)), "image/jpg");

PackageManager packageManager = getPackageManager();
List<ResolveInfo> activities = packageManager.queryIntentActivities(i, 0);
boolean isIntentSafe = activities.size() > 0;

// Start an activity if it's safe
if (isIntentSafe) {
    startActivity(i);
}