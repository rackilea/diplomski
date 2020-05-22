import static yourPackageName.MainActivity.sdf; // get static imports


    public class MyPicker extends DatePickerDialog {

    Context context;
    @Override
    public DatePicker getDatePicker() {
        return super.getDatePicker();
    }


    public MyPicker(Context context, int themeResId, OnDateSetListener listener, int year, int monthOfYear, int dayOfMonth) {
        super(context, themeResId, listener, year, monthOfYear, dayOfMonth);
        this.context = context;
    }

    @Override
    public void onDateChanged(DatePicker view, int year, int month, int dayOfMonth) {
        myCalendar.set(Calendar.YEAR, year);
        myCalendar.set(Calendar.MONTH, month);
        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        datePicker.setText(sdf.format(myCalendar.getTime()));
        datePickerDialog.dismiss();
    }
}