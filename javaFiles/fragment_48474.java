public class MyApplication extends Application {

   @Override
   public void onCreate() {

   super.onCreate();

   // configure Flurry
   FlurryAgent.setLogEnabled(false);

   // init Flurry
   FlurryAgent.init(this, MY_FLURRY_APIKEY);
 }
}