private void shareTwitter(String message) {
    Intent tweetIntent = new Intent(Intent.ACTION_SEND);
    tweetIntent.putExtra(Intent.EXTRA_TEXT, "This is a Test.");
    tweetIntent.setType("text/plain");

    PackageManager packManager = getPackageManager();
    List<ResolveInfo> resolvedInfoList = packManager.queryIntentActivities(tweetIntent, PackageManager.MATCH_DEFAULT_ONLY);

    boolean resolved = false;
    for (ResolveInfo resolveInfo : resolvedInfoList) {
        if (resolveInfo.activityInfo.packageName.startsWith("com.twitter.android")) {
            tweetIntent.setClassName(
                    resolveInfo.activityInfo.packageName,
                    resolveInfo.activityInfo.name);
            resolved = true;
            break;
        }
    }
    if (resolved) {
        startActivity(tweetIntent);
    } else {
        Intent i = new Intent();
        i.putExtra(Intent.EXTRA_TEXT, message);
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://twitter.com/intent/tweet?text=" + urlEncode(message)));
        startActivity(i);
        Toast.makeText(this, "Twitter app isn't found", Toast.LENGTH_LONG).show();
    }
}

private String urlEncode(String s) {
    try {
        return URLEncoder.encode(s, "UTF-8");
    } catch (UnsupportedEncodingException e) {
        Log.wtf(TAG, "UTF-8 should always be supported", e);
        return "";
    }
}