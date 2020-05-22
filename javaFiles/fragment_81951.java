public class displayTime extends AppCompatActivity {
TextView textView;
int hour,min;
@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    textView=findViewById(R.id.amTvData);
    Calendar mcurrentTime = Calendar.getInstance();
    hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
    min = mcurrentTime.get(Calendar.MINUTE);

    textView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showTime(hour,min);
         }
    });
}
void showTime(int hours,  int minte){
    TimePickerDialog mTimePicker;
    mTimePicker = new TimePickerDialog(displayTime.this, new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
            textView.setText( selectedHour + ":" + selectedMinute);
            hour=selectedHour;
            min=selectedMinute;
        }
    }, hours, minte, false);//Yes 24 hour time
    mTimePicker.setTitle("Select Time");
    mTimePicker.show();

}
}