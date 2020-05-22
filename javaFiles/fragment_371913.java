if(position == 0) {
    try
    {
        Intent i = new Intent(Intent.ACTION_MAIN);
        PackageManager managerclock = getPackageManager();
        i = managerclock.getLaunchIntentForPackage("com.test.example");
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        startActivity(i);
    }
    catch(Exception e)
    {
        //Do what ever you want
    }

}