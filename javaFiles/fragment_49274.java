public class AlarmActivity extends AppCompatActivity {

private Ringtone r;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
    setContentView(R.layout.activity_alarm);
    Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
    r = RingtoneManager.getRingtone(this, notification);
    r.play();

    ImageView buttonCancelAlarm = (ImageView) findViewById(R.id.buttonCancelAlarm);

    buttonCancelAlarm.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            cancelAlarm(Test.this);
            finish();
        }
    });

}
public void cancelAlarm(Context context)
{
    r.stop();
    Intent intent = new Intent(context, Alarm.class);
    PendingIntent sender = PendingIntent.getBroadcast(context, 12345, intent, 0);
    AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    alarmManager.cancel(sender);
}