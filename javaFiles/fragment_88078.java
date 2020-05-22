public class Main extends Application {
public String device_ID(){
    final TelephonyManager tm = (TelephonyManager) getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
    return tm.getDeviceId();
   }
}