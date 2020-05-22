public class AddInterestedKarmaActivity extends AppCompatActivity {

    DatePickerFragment datePickerDialog;
    EditText dateEdittext;
    String customDate = "12/12/2007"; //dd/mm/yy

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_interested_karma);


        dateEdittext = (EditText) findViewById(R.id.date_edit);
        //  setDate(dateEditText);


        datePickerDialog = new DatePickerFragment();
        datePickerDialog.day_ = getDay();
        datePickerDialog.month_ = getMonth();
        datePickerDialog.year_ = getYear();

        datePickerDialog.setCallbackListener(new DatePickerFragment.onDatePickerListener() {
                                                 @Override
                                                 public void onDataSet(int year, int month, int day) {
                                                     month = month + 1;
                                                     dateEdittext.setText(day + "/" + month + "/" + year);

                                                 }
                                             }
        );

        datePickerDialog.show(getSupportFragmentManager(), "datePicker");

    }

    private int getYear() {
        return Integer.parseInt(changeDateFormat(customDate, "MM/dd/yyyy", "YYYY"));

    }

    private int getMonth() {
        return Integer.parseInt(changeDateFormat(customDate, "MM/dd/yyyy", "MM")) - 1;  //substract one from month because month gets start from 0 in Calendar.

    }

    private int getDay() {
        return Integer.parseInt(changeDateFormat(customDate, "MM/dd/yyyy", "dd"));
    }


    public String changeDateFormat(String dateString, String sourceDateFormat, String targetDateFormat) {
        if (dateString == null || dateString.isEmpty())
            return "";

        SimpleDateFormat inputDateFromat = new SimpleDateFormat(sourceDateFormat, Locale.US);
        Date date = new Date();

        try {
            date = inputDateFromat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        SimpleDateFormat outputDateFormat = new SimpleDateFormat(targetDateFormat, Locale.US);

        return outputDateFormat.format(date);
    }


}