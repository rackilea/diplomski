public class Main extends Activity {
EditText et1,et2;
static final int DATE_DIALOG_ID = 0;
static final int DATE_DIALOG_ID1 = 1;
private int mYear;
private int mMonth;
private int mDay;

private int mYear1;
private int mMonth1;
private int mDay1;
/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    et1=(EditText)findViewById(R.id.EditText01);
    et2=(EditText)findViewById(R.id.EditText02);

    final Calendar c = Calendar.getInstance();
    mYear = c.get(Calendar.YEAR);
    mMonth = c.get(Calendar.MONTH);
    mDay = c.get(Calendar.DAY_OF_MONTH);
    et1.setText("month/year");
    et2.setText("month/year");
    et1.setOnTouchListener(new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            // TODO Auto-generated method stub
            showDialog(DATE_DIALOG_ID);
            return false;
        }
    });

    et2.setOnTouchListener(new OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            // TODO Auto-generated method stub
            showDialog(DATE_DIALOG_ID1);
            return false;
        }
    });

}

@Override
protected Dialog onCreateDialog(int id) {
    switch (id) {
    case DATE_DIALOG_ID:
        return new DatePickerDialog(this, mDateSetListener, mYear, mMonth,
                mDay);

    case DATE_DIALOG_ID1:
        return new DatePickerDialog(this, mDateSetListener1, mYear1, mMonth1,
                mDay1);
    }
    return null;
}

// updates the date in the TextView

private void updateDisplay() {
    et1.setText(new StringBuilder()
    // Month is 0 based so add 1
            .append(mMonth + 1).append("-").append(mYear));
}
private void updateDisplay1() {

    et2.setText(new StringBuilder()
    // Month is 0 based so add 1
            .append(mMonth1 + 1).append("-").append(mYear1));
}
// the callback received when the user "sets" the date in the dialog
private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear,
            int dayOfMonth) {
        // TODO Auto-generated method stub
        mYear = year;
        mMonth = monthOfYear;
        mDay = dayOfMonth;
        updateDisplay();
    }
};

private DatePickerDialog.OnDateSetListener mDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
    @Override
    public void onDateSet(DatePicker view, int year1, int monthOfYear1,
            int dayOfMonth1) {
        // TODO Auto-generated method stub
        mYear1 = year1;
        mMonth1 = monthOfYear1;
        mDay1 = dayOfMonth1;
        updateDisplay1();
    }
};