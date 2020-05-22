Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.instagram.android");
if (launchIntent != null)
{
    try
    {
        startActivity(launchIntent);
    }
    catch (ActivityNotFoundException ex) // in case Instagram not installed in your device
    {
        ex.printStackTrace();
    }
}