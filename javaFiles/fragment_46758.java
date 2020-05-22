public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Calendar cal_alarm = Calendar.getInstance();
        cal_alarm.setTimeInMillis(System.currentTimeMillis()); // i added this to ensure the calendar is being configured correctly
        cal_alarm.set(Calendar.HOUR_OF_DAY,14);
        cal_alarm.set(Calendar.MINUTE,46);
        cal_alarm.set(Calendar.SECOND,00);

        //check if time has already passed today, adjust alarm to tomorrow if it has
        if (cal_alarm.getTimeInMillis() < System.currentTimeMillis()) {
            cal_alarm.add(Calendar.DATE, 1);
        }

        Intent intent = new Intent(this, AlarmBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, PendingIntent.FLAG_ONE_SHOT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal_alarm.getTimeInMillis() , pendingIntent);
    }
}