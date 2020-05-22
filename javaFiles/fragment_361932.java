public class TestService extends Service {

    @Override
    public void onCreate()
    {
        ActivityManager am = (ActivityManager)this.getSystemService(ACTIVITY_SERVICE);
        List rs = am.getRunningServices(50);

        for (int i=0; i<rs.size(); i++) {
        ActivityManager.RunningServiceInfo rsi = (RunningServiceInfo) rs.get(i);
        Log.i("Service", "Process " + rsi.process + " with component " + rsi.service.getClassName());
        }
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"1. onCreate()", Toast.LENGTH_SHORT).show();
    }
}