@SuppressWarnings("deprecation")
    private void getRunningAppName() throws NameNotFoundException {
        Log.v("neiltag", "Entered getRunningAppName()");
        ActivityManager am = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
        // The first in the list of RunningTasks is always the foreground task.
        RunningTaskInfo foregroundTaskInfo = am.getRunningTasks(1).get(0);

        String foregroundTaskPackageName = foregroundTaskInfo .topActivity.getPackageName();
        PackageManager pm = this.getPackageManager();
        PackageInfo foregroundAppPackageInfo = pm.getPackageInfo(foregroundTaskPackageName, 0);
        String foregroundTaskAppName = foregroundAppPackageInfo.applicationInfo.loadLabel(pm).toString();
        String packageName = foregroundAppPackageInfo.packageName;



        if(foregroundTaskAppName.matches("<NAME OF YOUR APP HERE>")) {

            //If your app is fired go back to the Homescreen(i.e. the delay)
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(startMain);

            handler.post(new Runnable() {  
                   @Override  
                   public void run() {  
                      Toast.makeText(getApplicationContext(), "You are not allowed to open Facbeook now, sorry!", Toast.LENGTH_SHORT).show();  
                   }  
                });


        } 

                           //ADD A TIMER HERE 
                           //ONCE TIMER EXPIRES, FIRE UP YOUR APP AGAIN 

    }