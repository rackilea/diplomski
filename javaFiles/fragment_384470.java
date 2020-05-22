public class MyActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        DatePicker datePicker = (DatePicker) findViewById(R.id.date);

        final int MIN_YEAR = 2011;
        final int MAX_YEAR = 2011;

        datePicker.init(MIN_YEAR /* initial year */,
                        01 /* initial month of year */,
                        01 /* initial day of month */,
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker datePicker,
                                              int year,
                                              int monthOfYear,
                                              int dayOfMonth) {

                        // Override changing year to anything different from outside the range <MIN_YEAR, MAX_YEAR>
                        if (year < MIN_YEAR) {
                            datePicker.updateDate(MIN_YEAR, monthOfYear, dayOfMonth);
                        } else if (year > MAX_YEAR) {
                            datePicker.updateDate(MAX_YEAR, monthOfYear, dayOfMonth);
                        }
                    }

                });
    }
}