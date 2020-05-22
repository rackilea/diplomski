String PLAY_BOOKS_PACKAGE_NAME = "com.google.android.apps.books";
PackageManager packageManager = context.getPackageManager();
Intent launchIntent = packageManager
    .getLaunchIntentForPackage(PLAY_BOOKS_PACKAGE_NAME);
if (launchIntent != null) {
    startActivity(launchIntent);
} else {
    Toast.makeText(context, "Google Books is NOT Installed",
        Toast.LENGTH_SHORT).show();
}