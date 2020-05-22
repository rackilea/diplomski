try {
Intent LaunchIntent =
getPackageManager().getLaunchIntentForPackage("com.instagram.android");
startActivity(LaunchIntent); 
//Here you can add more information, such as the specific profile that you want to launch,    in Intent format 
 }

    catch (Exception myIntent) {
        //TODO Auto-generated catch block
        Intent browserIntent = new Intent(Intent.ACTION_VIEW,    Uri.parse("https://play.google.com/store/apps/details?id=com.instagram.android"));
    startActivity(browserIntent);
    }