public class MainActivity extends Activity
{
   @Override
   public void onCreate(Bundle savedInstanceState) 
  {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);
            //call function where you want
            timeout();
  }

public void timeout()
{       //time in milliseconds 1 minute
        Long time = new GregorianCalendar().getTimeInMillis()+60*1000; //i.e.60*1000=1minute
        // create an Intent and set the class which will execute when Alarm triggers, here we have
        Intent intentAlarm = new Intent(this, AlarmReciever.class);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,time, PendingIntent.getBroadcast(this,1,  intentAlarm, PendingIntent.FLAG_UPDATE_CURRENT));

    }
}