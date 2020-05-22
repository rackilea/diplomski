@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_timer_settings);
    NumberPicker np = (NumberPicker)findViewById(R.id.numberPicker2);
    np.setMinValue(1);
    np.setMaxValue(999);
    np.setWrapSelectorWheel(false);

    final Button testbutton = (Button) findViewById(R.id.testbutton);
    testbutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent testintent = new Intent(timer_settings.this, timer_2.class);
Bundle timer2extras = new Bundle();
            timer2extras.putString("timer2string", np.getValue() + "");
            timer2.putExtras(timer2extras);
            startActivity(testintent);
        }
    });
}