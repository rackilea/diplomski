boolean installed  = appInstalledOrNot("com.example.package");
            if(installed){
                final Intent intent = new Intent(Intent.ACTION_MAIN, null);

                final ComponentName cn = new ComponentName("com.example.package",
                       "com.example.package.ActivityClass" );
                intent.setComponent(cn);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);
}else{
     // not installed
             String marketUri = "market://details?id=com.example.package";
                 Intent goToMarket = new Intent(Intent.ACTION_VIEW)
                                    .setData(Uri.parse(marketUri));


                 startActivity(goToMarket);
}

    }    
    public static boolean appInstalledOrNot(String package)
        {
            PackageManager pm = getPackageManager();
            boolean app_installed;
            try
            {
                pm.getPackageInfo(package, PackageManager.GET_ACTIVITIES);
                app_installed = true;
            }
            catch (PackageManager.NameNotFoundException e)
            {
                app_installed = false;
            }
            return app_installed ;
        }