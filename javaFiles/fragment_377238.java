public class SampleApplication extends Application {
   public void onCreate(){
       super.onCreate();
       Parse.enableLocalDatastore(getApplicationContext());
       Parse.initialize(this, "PARSE_APP_KEY", "PARSE_CLIENT_KEY");
        ParseInstallation.getCurrentInstallation().saveInBackground();
   }
}