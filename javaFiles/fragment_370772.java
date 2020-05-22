private void ShareSub() {
    final Intent i = new Intent(Intent.ACTION_SEND);
    i.setType("text/plain");
    i.putExtra(Intent.EXTRA_TEXT,"text");

    final List<ResolveInfo> activities = getPackageManager().queryIntentActivities (i, 0);

    List<String> appNames = new ArrayList<String>();
    for (ResolveInfo info : activities) {
        appNames.add(info.loadLabel(getPackageManager()).toString());
    }

    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("Complete Action using...");
    builder.setItems(appNames.toArray(new CharSequence[appNames.size()]), new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int item) {
            ResolveInfo info = activities.get(item);
            if (info.activityInfo.packageName.equals("com.facebook.katana")) {
                // Facebook was chosen
            } else if (info.activityInfo.packageName.equals("com.twitter.android")) {
                // Twitter was chosen
            }

            // start the selected activity
            i.setPackage(info.activityInfo.packageName);
            startActivity(i);
        }
    });
    AlertDialog alert = builder.create();
    alert.show();
}