public void installApp(){
    File mFile = new File(Uri.parse(downloadedPackageUriString).getPath());
    Intent promptInstall = new Intent(Intent.ACTION_VIEW)
            .setDataAndType(Uri.fromFile(mFile), "application/vnd.android.package-archive")
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    appContext.startActivity(promptInstall);

    Thread t = new Thread(){
        public void run(){

            boolean installed = checkInstalled("vnd.android.package-archive");
            while(!installed)
            {
                System.out.println("Not Installed Yet..Waiting 1 Second");
                t.sleep(1000);
            }

            //Now it has been installed
            if(installed) {
                //This intent will help you to launch if the package is already installed
                Intent LaunchIntent = getPackageManager()
                    .getLaunchIntentForPackage("com.Ch.Example.pack");
                startActivity(LaunchIntent);

                System.out.println("App already installed on your phone");        
            }
            else {
                System.out.println("App is not installed on your phone");
            }
            }
    t.start();
}

private boolean checkInstalled(String uri) {
    PackageManager pm = getPackageManager();
    boolean app_installed = false;
    try {
        pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
        app_installed = true;
    }
    catch (PackageManager.NameNotFoundException e) {
        app_installed = false;
    }
    return app_installed ;
}