private TextView timerMetric;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_work_timer_notification);

    timerMetric = (TextView)findViewById(R.id.tester_texter);

    if(caseA) {
        timerMetric.setText("min");
    }
}