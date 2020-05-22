public class MainActivity extends AppCompatActivity {


    public static Calendar myCalendar = Calendar.getInstance();


    public static String myFormat = "MM/dd/yy";
    public static SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
    public static EditText datePicker;
    public static MyPicker datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        datePicker = (EditText) findViewById(R.id.popUpDate);
        datePicker.setText(sdf.format(myCalendar.getTime()));

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog = new MyPicker(MainActivity.this, R.style.AppTheme_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    }
                }, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }

        });
    }

}
}