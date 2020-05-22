private int appversion;
        // Main activity  {

          //onCreate(){



     }

        public Void getID(){
         try {
                    PackageInfo pInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
                    int verCode = BuildConfig.VERSION_CODE;
                    String version = pInfo.versionName;
                    versionq = version;
                    appversion = verCode ;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
}