public class MainActivity extends AppCompatActivity {

    public  String myFormat = "MM/dd/yy";
    public  SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
    public  EditText datePicker;
    final Calendar calendar = Calendar.getInstance();
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        datePicker = (EditText) findViewById(R.id.popUpDate);
        datePicker.setText(sdf.format(calendar.getTime()));

        datePicker.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                datePickerDialog = new DatePickerDialog(MainActivity.this, null, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.getDatePicker().init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        datePicker.setText(sdf.format(calendar.getTime()));
                        datePickerDialog.dismiss();
                    }
                });
                datePickerDialog.show();
            }
        });
    }
}