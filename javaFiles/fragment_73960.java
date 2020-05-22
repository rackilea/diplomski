String myPackageName = getPackageName();
String[] blacklist = new String[]{"com.pinterest", "com.tunewiki.lyricplayer.android", "com.dropbox.android", "com.google.zxing.client.android", "com.adobe.reader", "com.google.android.apps.docs", "flipboard.app"};
Set<Integer> usedSharingApps = new HashSet<Integer>();
int facebookHash1 = "com.facebook.katana".hashCode();
int facebookHash2 = "com.facebook.wakizashi".hashCode();

// share result
// By default intent only link is possible to share on facebook                         

    List<Intent> targetedShareIntents = new ArrayList<Intent>();

    Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
    shareIntent.setType("text/plain");
List<ResolveInfo> resInfo = getPackageManager().queryIntentActivities(shareIntent, 0);
if (!resInfo.isEmpty()){
    for (ResolveInfo resolveInfo : resInfo) {
        String packageName = resolveInfo.activityInfo.packageName;

        Intent targetShareIntent;
        int appId = packageName.hashCode();
        if (packageName.equals(myPackageName) 
            || Arrays.asList(blacklist).contains(packageName) /* skip some other packages */
            || usedSharingApps.contains(appId)) {
            continue;
        } else if (packageName.equals("com.facebook.katana") || packageName.equals("com.facebook.wakizashi")) {
            usedSharingApps.add(appId);
            Intent targetShareIntentTmp = new Intent(getApplicationContext(), ShareFacebook.class);
            targetShareIntentTmp.addCategory("android.intent.category.ALTERNATIVE");

            targetShareIntentTmp.setAction(Intent.ACTION_SEND);
            targetShareIntentTmp.setType("text/plain");
            targetShareIntentTmp.setPackage(myPackageName);
            targetShareIntentTmp.setComponent(new ComponentName(getPackageName(), ShareFacebook.class.getName()));
            targetShareIntentTmp.putExtra(Intent.EXTRA_SUBJECT, "FacebookDialog Description");
            targetShareIntentTmp.putExtra(Intent.EXTRA_TITLE, "FacebookDialog Name");
            targetShareIntentTmp.putExtra(Intent.EXTRA_TEXT, "http://stackoverflow.com");

            targetShareIntent = new LabeledIntent(targetShareIntentTmp, myPackageName, R.string.facebook, R.drawable.fb_logo_blue);

        } else {
            usedSharingApps.add(appId);
            targetShareIntent = new Intent();   

            targetShareIntent.setAction(Intent.ACTION_SEND);
            targetShareIntent.setType("text/plain");
            targetShareIntent.setPackage(packageName);

            targetShareIntent.putExtra(Intent.EXTRA_SUBJECT, "SUBJECT visible by mail or sms app");
            targetShareIntent.putExtra(Intent.EXTRA_TITLE, "TITLE - visible anywhere?");
            targetShareIntent.putExtra(Intent.EXTRA_TEXT, "All this text visible in every intent http://www.google.com/");
        }
        targetedShareIntents.add(targetShareIntent);
    }
}               

if (!usedSharingApps.contains(facebookHash1) && !usedSharingApps.contains(facebookHash2)) {
    // user does not have facebook app but we still want to share since it took us such effort to use facebook sharing!

    Intent targetShareIntentTmp = new Intent(getApplicationContext(), ShareFacebook.class);
    targetShareIntentTmp.addCategory("android.intent.category.ALTERNATIVE");

    targetShareIntentTmp.setAction(Intent.ACTION_SEND);
    targetShareIntentTmp.setType("text/plain");
    targetShareIntentTmp.setPackage(myPackageName);
    targetShareIntentTmp.setComponent(new ComponentName(getPackageName(), ShareFacebook.class.getName()));
    targetShareIntentTmp.putExtra(Intent.EXTRA_SUBJECT, "FacebookDialog Description");
    targetShareIntentTmp.putExtra(Intent.EXTRA_TITLE, "FacebookDialog Name");
    targetShareIntentTmp.putExtra(Intent.EXTRA_TEXT, "http://stackoverflow.com");

    Intent targetShareIntent = new LabeledIntent(targetShareIntentTmp, myPackageName, R.string.facebook, R.drawable.fb_logo_blue);
    targetedShareIntents.add(targetShareIntent);
}

Intent chooserIntent = Intent.createChooser(targetedShareIntents.remove(0), "Select app to share");
chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, targetedShareIntents.toArray(new Parcelable[]{}));
startActivity(chooserIntent);