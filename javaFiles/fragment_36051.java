try{
    ApplicationInfo info = getPackageManager().
            getApplicationInfo("com.facebook.android", 0 );
    return true;
} catch( PackageManager.NameNotFoundException e ){
    return false;
}