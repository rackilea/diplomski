//imports here
public class AlarmService extends Service{

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        //System.out.println("hello im in the alarmService Binder");

        return null;
    }

    @Override
    public void onStart(Intent intent, int startid) {
        Intent mainAct = new Intent("android.intent.action.MAIN");
        //System.out.println("hello im in the alarmService onStart " + mainAct);
        mainAct.setClass(AlarmService.this, MainActivity.class);
        mainAct.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mainAct.putExtra("alarm","true");
        startActivity(mainAct);
    }

    @Override
    public void onCreate() {
        //System.out.println("hello im in the alarmService onCreate");
        //code to execute when the service is first created
    }

}