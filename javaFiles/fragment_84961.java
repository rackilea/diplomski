public class MyDatePicker {
DatePickerDialog mDatePickerDialog;


public interface onDateSet {
    public void onDate(DatePicker view, int year, int monthOfYear,
            int dayOfMonth);
}

onDateSet mOnDateSet;

public void setDateListener(onDateSet mOnDateSet) {
    this.mOnDateSet = mOnDateSet;
}
public MyDatePicker(Context ctx) {
    mDatePickerDialog = new DatePickerDialog(ctx, new OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                int dayOfMonth) {
            mOnDateSet.onDate(view, year, monthOfYear, dayOfMonth);

        }
    }, 2000, 1, 1);
}

public void show() {
    mDatePickerDialog.show();
}