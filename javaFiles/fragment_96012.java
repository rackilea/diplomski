class ThepooshApplication extends Application {

    private static sIsRegistered = false;

    public static setIsRegistered(boolean isRegistered) { sIsRegistered = isRegistered; }

    public void onCreate() {
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks(){
            @Override
            void onActivityCreated(Activity activity, Bundle savedInstanceState){
                if (!sIsRegistered && !(activity instanceof LoginActivity)) {
                    Intent loginIntent = new Intent(this, LoginActivity.class);
                    loginIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK 
                        | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(loginIntent);
                }
            }
            @Override
            void onActivityStarted(Activity activity) { /*empty method*/ }
            @Override
            void onActivityResumed(Activity activity) { /*empty method*/ }
            @Override
            void onActivityPaused(Activity activity) { /*empty method*/ }
            @Override
            void onActivityStopped(Activity activity) { /*empty method*/ }
            @Override
            void onActivitySaveInstanceState(Activity activity, Bundle outState) { /*empty method*/ }
            @Override
            void onActivityDestroyed(Activity activity) { /*empty method*/ }
        });
    }
}