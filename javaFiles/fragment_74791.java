public class MyActivity extends AppCompatActivity {

    private txtStatusView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myLayoutWithTextView);
        txtStatusView = findViewById(R.id.txtStatus);

        LocalBroadcastManager.getInstance(this).registerReceiver(
            statusReceiver, new IntentFilter(PowerConnectionReceiver.ACTION_STATUS_CHANGE)
        );
    }

    @Override
    protected void onDestroy() {
      LocalBroadcastManager.getInstance(this).unregisterReceiver(statusReceiver);
      super.onDestroy();
    }

    private BroadcastReceiver statusReceiver = new BroadcastReceiver() {
      @Override
      public void onReceive(Context context, Intent intent) {
        String status = intent.getStringExtra(PowerConnectionReceiver.EXTRA_STATUS);
        txtStatusView.setText(status);
      }
    };
}