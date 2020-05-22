public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    private onDatePickerListener mListener;
    private boolean future;
    int day_;
    int month_;
    int year_;
    private DatePickerDialog datePickerDialog;


    public DatePickerFragment() {

    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
//        final Calendar c = Calendar.getInstance();
//        int year = c.get(Calendar.YEAR);
//        int month = c.get(Calendar.MONTH);

        //    Log.d("DATE_PICKER", " CURRENT_MONTH " + month);

        //   int day = c.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(getActivity(), R.style.AppTheme, this, year_, month_, day_);

        if (isFuture() == false) {
            datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        }
      //  datePickerDialog.updateDate(year_, month_, day_);

        // Create a new instance of DatePickerDialog and return it
        return datePickerDialog;
    }


    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        callListener(year, month, day);
    }

    public DialogFragment setCallbackListener(onDatePickerListener listener) {
        mListener = listener;
        return null;
    }

    private void callListener(int year, int month, int day) {
        if (mListener != null) mListener.onDataSet(year, month, day);
    }

    public boolean isFuture() {
        return future;
    }

    public void setFuture(boolean future) {
        this.future = future;
    }

    public interface onDatePickerListener {
        void onDataSet(int year, int month, int day);
    }
}