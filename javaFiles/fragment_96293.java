String packageName = "org.mozilla.firefox";
Intent intent= getPackageManager().getLaunchIntentForPackage(packageName);
if (intent != null){
    startActivity(intent);
}else{
    try {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName)));
    }catch (android.content.ActivityNotFoundException anfe) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
    }
}