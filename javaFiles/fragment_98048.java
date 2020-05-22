public static void initialize(Application context) {
    appContext.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
       ...
       @Override
       public void onActivityResumed(Activity activity) {
           sGlobalContext = activity; 
       }
       @Override
       public void onActivityPaused(Activity activity) {
           sGlobalContext = null; 
       }
       ....
    ...
}