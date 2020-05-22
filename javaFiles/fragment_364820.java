public class MainActivity extends FragmentActivity implements
    DatePickerFragment.DatePickedListener, TimePickerFragment.TimePickedListener {

    TextView dateView, timeView;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateView = (TextView) findViewById(R.id.dateTextID);
        timeView = (TextView) findViewById(R.id.timeTextID);

    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getFragmentManager(), "datePicker");
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");
    }

    @Override
    public void onDatePicked(String date) {
        dateView.setText(date);
    }

    @Override
    public void onTimeSet(String time) {
        timeView.setText(time);
    }
}