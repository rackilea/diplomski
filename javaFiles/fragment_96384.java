public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver alarmReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // the "MainActivity.this" tells it to use the method from the parent class
            MainActivity.this.updateMyTextView();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRecurringAlarm(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        final IntentFilter filter = new IntentFilter();
        filter.addAction("YOUR_ACTION_NAME"); 
        registerReceiver(alarmReceiver, filter);
    }

    @Override
    protected void onStop() {
        unregisterReceiver(alarmReceiver);
        super.onStop();
    }

    private void updateMyTextView(){
        final TextView myTextView = findViewById(R.id.my_text);
        if (myTextView != null){
            CharSequence myCharSequence = "Set from UpdateReceiver.onReceive()";
            myTextView.post(()-> myTextView.setText(myCharSequence));
        }
    }

    private void setRecurringAlarm(Context context) {
        Intent intent = new Intent("YOUR_ACTION_NAME");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context, 0, intent,
                PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        alarmManager.setInexactRepeating(
                AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + 1000,
                1000, // Set so short for demo purposes only.
                pendingIntent
        );
    }
}